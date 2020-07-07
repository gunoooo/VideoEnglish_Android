package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.PlaylistCache
import kr.hs.dgsw.data.database.entity.PlaylistEntity
import kr.hs.dgsw.data.mapper.PlaylistMapper
import kr.hs.dgsw.data.network.remote.PlaylistRemote
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.YoutubeData
import javax.inject.Inject

class PlaylistDataSource @Inject constructor(
        override val remote: PlaylistRemote,
        override val cache: PlaylistCache
): BaseDataSource<PlaylistRemote, PlaylistCache>() {

    private val playlistMapper = PlaylistMapper()

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