package kr.hs.dgsw.data.repository

import kr.hs.dgsw.data.datasource.HidingDataSource
import kr.hs.dgsw.data.datasource.PlaylistDataSource
import com.gunwoo.karaoke.data.exception.ListEmptyException
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.util.Constants
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.PlaylistRepository
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
        private val playlistDataSource: PlaylistDataSource,
        private val hidingDataSource: HidingDataSource
) : PlaylistRepository {

    override fun insertDefaultPlaylistsList(): Completable {
        return deleteAllPlaylist().andThen(
                playlistDataSource.insertDefaultPlaylistsList(Constants.HOME_PLAYLIST_ID).andThen(
                        playlistDataSource.insertDefaultPlaylistsList(Constants.HOME2_PLAYLIST_ID).andThen(
                                playlistDataSource.insertDefaultPlaylistsList(Constants.HOME3_PLAYLIST_ID).andThen(
                                        playlistDataSource.insertDefaultPlaylistsList(Constants.HOME4_PLAYLIST_ID)
                                )
                        )
                )
        )
    }

    override fun getDefaultPlaylistsList(): Single<List<YoutubeData>> {
        return playlistDataSource.getDefaultPlaylistsList().flatMap { playlistList ->
            hidingDataSource.getHidingList().flatMap { hidingList ->
                Single.just(getResultPlaylistsList(playlistList.shuffled().take(50), hidingList))
            }
        }
    }

    override fun getPlaylistsList(id: String): Single<List<YoutubeData>> {
        return playlistDataSource.getPlaylistsList(id).flatMap { playlistList ->
            hidingDataSource.getHidingList().flatMap { hidingList ->
                Single.just(getResultPlaylistsList(playlistList, hidingList))
            }
        }.map { if (it.isEmpty()) throw ListEmptyException("검색 결과가 없습니다") else it }
    }

    override fun deleteAllPlaylist(): Completable {
        return playlistDataSource.deleteAllPlaylist()
    }

    private fun getResultPlaylistsList(playlistList: List<YoutubeData>, hidingList: List<YoutubeData>): List<YoutubeData> {
        val list = ArrayList<YoutubeData>()

        playlistList.forEach { playlistItem ->
            var isHidden = false

            hidingList.forEach { hiding ->
                if (hiding.videoId == playlistItem.videoId)
                    isHidden = true
            }

            if (!isHidden)
                list.add(playlistItem)
        }

        return list
    }
}