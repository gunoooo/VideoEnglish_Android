package kr.hs.dgsw.data.repository

import kr.hs.dgsw.data.datasource.SearchHistoryDataSource
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.repository.SearchHistoryRepository
import javax.inject.Inject

class SearchHistoryRepositoryImpl @Inject constructor(
    private val searchHistoryDataSource: SearchHistoryDataSource
) : SearchHistoryRepository {

    override fun getSearchHistoryList(): Single<List<String>> {
        return searchHistoryDataSource.getSearchHistoryList()
    }

    override fun deleteSearchHistory(search: String): Completable {
        return searchHistoryDataSource.deleteSearchHistory(search)
    }

    override fun deleteAll(): Completable {
        return searchHistoryDataSource.deleteAll()
    }
}