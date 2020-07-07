package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.domain.model.PlaylistItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistService {
    @GET("playlist")
    fun getPlaylistsList(
        @Query("playlistId") playlistId: String
    ): Single<Response<List<PlaylistItem>>>
}