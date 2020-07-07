package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.domain.model.Search
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search")
    fun getSearchList(
        @Query("search") search: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int
    ): Single<Response<List<Search>>>
}