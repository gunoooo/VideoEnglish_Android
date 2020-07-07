package kr.hs.dgsw.domain.usecase.searchhistory

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.SearchHistoryRepository
import io.reactivex.Completable
import javax.inject.Inject

class DeleteSearchHistoryUseCase @Inject constructor(
    private val searchHistoryRepository: SearchHistoryRepository
) : ParamsUseCase<DeleteSearchHistoryUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return searchHistoryRepository.deleteSearchHistory(params.search)
    }

    data class Params(
        val search: String
    )
}