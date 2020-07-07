package kr.hs.dgsw.data.network.remote

import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.SearchService
import io.reactivex.Single
import kr.hs.dgsw.domain.model.Search

class SearchRemote(override val service: SearchService) : BaseRemote<SearchService>() {

    fun getSearchList(search: String, channelId: String, maxResults: Int): Single<List<Search>> =
        service.getSearchList(search, channelId, maxResults).map(getResponse())
}