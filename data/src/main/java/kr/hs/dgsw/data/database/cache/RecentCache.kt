package kr.hs.dgsw.data.database.cache

import android.app.Application
import kr.hs.dgsw.data.base.BaseCache
import kr.hs.dgsw.data.database.entity.RecentEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RecentCache @Inject constructor(application: Application) : BaseCache(application) {

    private val recentDao = database.recentDao()

    fun getRecentList(): Single<List<RecentEntity>> = recentDao.getRecentList()

    fun insertRecent(recentEntity: RecentEntity): Completable = recentDao.insert(recentEntity)
}