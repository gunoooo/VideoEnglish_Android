package kr.hs.dgsw.domain.usecase.record

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Record
import kr.hs.dgsw.domain.repository.RecordRepository
import kr.hs.dgsw.domain.util.yearDateWeekFormat
import io.reactivex.Completable
import java.io.File
import java.util.*
import javax.inject.Inject

class InsertRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository
) : ParamsUseCase<InsertRecordUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return recordRepository.insertRecord(
            Record(
                params.title,
                Date().yearDateWeekFormat(),
                params.thumbnail,
                params.file
            )
        )
    }

    data class Params(
        val title: String,
        val thumbnail: String,
        val file: File
    )
}