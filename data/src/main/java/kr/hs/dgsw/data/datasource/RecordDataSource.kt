package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.RecordCache
import kr.hs.dgsw.data.database.entity.RecordEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RecordDataSource @Inject constructor(
    override val remote: Any,
    override val cache: RecordCache
) : BaseDataSource<Any, RecordCache>() {

    fun getRecordList(): Single<List<RecordEntity>> = cache.getRecordList().map { recordEntityList -> recordEntityList.sortedByDescending { it.idx } }

    fun insertRecord(recordEntity: RecordEntity): Completable = cache.insertRecord(recordEntity)
}