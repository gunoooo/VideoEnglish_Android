package kr.hs.dgsw.domain.repository

import kr.hs.dgsw.domain.model.Record
import io.reactivex.Completable
import io.reactivex.Single

interface RecordRepository {
    fun getRecordList(): Single<List<Record>>

    fun insertRecord(record: Record): Completable
}