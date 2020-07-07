package kr.hs.dgsw.domain.usecase.record

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.Record
import kr.hs.dgsw.domain.repository.RecordRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRecordListUseCase @Inject constructor(
    private val recordRepository: RecordRepository
) : BaseUseCase<Single<List<Record>>>() {

    override fun buildUseCaseObservable(): Single<List<Record>> {
        return recordRepository.getRecordList()
    }
}