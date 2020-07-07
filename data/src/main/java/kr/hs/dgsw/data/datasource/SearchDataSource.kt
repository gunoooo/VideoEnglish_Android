package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.database.entity.SearchEntity
import kr.hs.dgsw.data.mapper.SearchMapper
import kr.hs.dgsw.data.network.remote.SearchRemote
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.YoutubeData
import javax.inject.Inject

class SearchDataSource @Inject constructor(
        override val remote: SearchRemote,
        override val cache: SearchCache
) : BaseDataSource<SearchRemote, SearchCache>() {

    private val searchMapper = SearchMapper()

    fun getSearchList(search: String, channelId: String, maxResults: Int): Single<List<YoutubeData>> =
        cache.getSearchList(search, channelId, maxResults).onErrorResumeNext { getSearchListRemote(search, channelId, maxResults) }
            .map { searchEntityList -> searchEntityList.map { searchMapper.mapToYoutubeData(it) } }

    fun deleteAllPlaylist(): Completable = cache.deleteAll()

    private fun getSearchListRemote(search: String, channelId: String, maxResults: Int): Single<List<SearchEntity>> {
        return remote.getSearchList(search, channelId, maxResults).map { searchList -> searchList.map { searchMapper.mapToEntity(it) } }
            .flatMap { searchList -> cache.insertSearchList(searchList).toSingleDefault(searchList) }
    }
}