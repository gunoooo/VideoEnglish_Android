package kr.hs.dgsw.data.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.PlaylistCache
import kr.hs.dgsw.data.database.entity.PlaylistEntity
import kr.hs.dgsw.data.mapper.PlaylistMapper
import kr.hs.dgsw.data.network.remote.PlaylistRemote
import kr.hs.dgsw.data.util.Constants
import kr.hs.dgsw.domain.model.YoutubeData
import javax.inject.Inject

class PlaylistDataSource @Inject constructor(
        override val remote: PlaylistRemote,
        override val cache: PlaylistCache
): BaseDataSource<PlaylistRemote, PlaylistCache>() {

    private val playlistMapper = PlaylistMapper()

    fun insertDefaultPlaylistsList(id: String): Completable {
        return getPlaylistsListRemote(id).ignoreElement()
    }

    fun getDefaultPlaylistsList(): Single<List<YoutubeData>> {
        val list = ArrayList<YoutubeData>()
        return cache.getPlaylistsList(Constants.HOME_PLAYLIST_ID)
                .flatMap { playlist1 -> list.addAll(playlist1.map { playlistMapper.mapToYoutubeData(it) })
                    cache.getPlaylistsList(Constants.HOME2_PLAYLIST_ID)
                        .flatMap { playlist2 -> list.addAll(playlist2.map { playlistMapper.mapToYoutubeData(it) })
                            cache.getPlaylistsList(Constants.HOME3_PLAYLIST_ID)
                                .flatMap { playlist3 -> list.addAll(playlist3.map { playlistMapper.mapToYoutubeData(it) })
                                    cache.getPlaylistsList(Constants.HOME4_PLAYLIST_ID)
                                            .flatMap { playlist4 -> list.addAll(playlist4.map { playlistMapper.mapToYoutubeData(it) })
                                                Single.just(list)
                                            }
                                }
                        }
                }
    }

    fun getPlaylistsList(id: String): Single<List<YoutubeData>> =
        cache.getPlaylistsList(id)
            .onErrorResumeNext { getPlaylistsListRemote(id) }
            .map { playlistEntityList -> playlistEntityList.map { playlistMapper.mapToYoutubeData(it) } }

    fun deleteAllPlaylist(): Completable = cache.deleteAll()

    private fun getPlaylistsListRemote(id: String): Single<List<PlaylistEntity>> =
        remote.getPlaylistsList(id)
            .map { playlistList -> playlistList.map { playlistMapper.mapToEntity(it) } }
            .flatMap { playlistsList -> cache.insertPlaylistsList(playlistsList).toSingleDefault(playlistsList) }
}