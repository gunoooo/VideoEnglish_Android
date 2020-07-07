package kr.hs.dgsw.data.database.cache

import android.app.Application
import kr.hs.dgsw.data.base.BaseCache
import kr.hs.dgsw.data.database.entity.SearchHistoryEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SearchHistoryCache @Inject constructor(application: Application) : BaseCache(application) {

    private val searchHistoryDao = database.searchHistoryDao()

    fun getSearchHistoryList(): Single<List<SearchHistoryEntity>> = searchHistoryDao.getSearchHistoryList()

    fun insertSearchHistory(searchHistoryEntity: SearchHistoryEntity): Completable = searchHistoryDao.insert(searchHistoryEntity)

    fun deleteSearchHistory(search: String): Completable = searchHistoryDao.delete(search)

    fun deleteAll(): Completable = searchHistoryDao.deleteAll()
}