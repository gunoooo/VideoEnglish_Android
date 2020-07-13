package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.response.PlaylistResponse
import kr.hs.dgsw.domain.model.PlaylistItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistService {
    @GET("playlistItems?part=snippet&type=video&maxResults=50&key=AIzaSyA1AA1ws32FEojCTyIqmtjOb8f5VKMOyf4")
    fun getPlaylistsList(
        @Query("playlistId") playlistId: String
    ): Single<Response<PlaylistResponse>>
}