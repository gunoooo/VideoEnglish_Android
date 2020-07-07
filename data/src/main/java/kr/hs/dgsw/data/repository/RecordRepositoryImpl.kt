package kr.hs.dgsw.data.repository

import kr.hs.dgsw.data.datasource.RecordDataSource
import kr.hs.dgsw.data.mapper.RecordMapper
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.Record
import kr.hs.dgsw.domain.repository.RecordRepository
import javax.inject.Inject

class RecordRepositoryImpl @Inject constructor(
    private val recordDataSource: RecordDataSource
) : RecordRepository {

    private val recordMapper = RecordMapper()

    override fun getRecordList(): Single<List<Record>> {
        return recordDataSource.getRecordList().map { recordEntityList -> recordEntityList.map { recordMapper.mapToModel(it) }.filter { it.file.isFile } }
    }

    override fun insertRecord(record: Record): Completable {
        return recordDataSource.insertRecord(recordMapper.mapToEntity(record))
    }
}