package kr.hs.dgsw.domain.repository

import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import io.reactivex.Single

interface PlaylistRepository {
    fun getPlaylistsList(id: String): Single<List<YoutubeData>>

    fun deleteAllPlaylist(): Completable
}