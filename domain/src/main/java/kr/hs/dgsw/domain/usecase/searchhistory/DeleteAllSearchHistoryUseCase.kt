package kr.hs.dgsw.domain.usecase.searchhistory

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.repository.SearchHistoryRepository
import io.reactivex.Completable
import javax.inject.Inject

class DeleteAllSearchHistoryUseCase @Inject constructor(
    private val searchHistoryRepository: SearchHistoryRepository
) : BaseUseCase<Completable>() {

    override fun buildUseCaseObservable(): Completable {
        return searchHistoryRepository.deleteAll()
    }
}