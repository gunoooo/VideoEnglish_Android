package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.SearchHistoryCache
import kr.hs.dgsw.data.database.entity.SearchHistoryEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SearchHistoryDataSource @Inject constructor(
    override val remote: Any,
    override val cache: SearchHistoryCache
) : BaseDataSource<Any, SearchHistoryCache>() {

    fun getSearchHistoryList(): Single<List<String>> = cache.getSearchHistoryList()
        .map { searchHistoryList -> searchHistoryList.sortedByDescending { it.idx }.map { it.search }.distinct().take(6) }

    fun insertSearchHistory(search: String): Completable = cache.insertSearchHistory(SearchHistoryEntity(search))

    fun deleteSearchHistory(search: String): Completable = cache.deleteSearchHistory(search)

    fun deleteAll(): Completable = cache.deleteAll()
}