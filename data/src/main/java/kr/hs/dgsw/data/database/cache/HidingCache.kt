package kr.hs.dgsw.data.database.cache

import android.app.Application
import kr.hs.dgsw.data.base.BaseCache
import kr.hs.dgsw.data.database.entity.HidingEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class HidingCache @Inject constructor(application: Application) : BaseCache(application) {

    private val hidingDao = database.hidingDao()

    fun getHidingList(): Single<List<HidingEntity>> = hidingDao.getHidingList()

    fun insertHiding(hidingEntity: HidingEntity): Completable = hidingDao.insert(hidingEntity)

    fun deleteHiding(hidingEntity: HidingEntity): Completable = hidingDao.delete(hidingEntity)
}