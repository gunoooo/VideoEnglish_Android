package kr.hs.dgsw.domain.usecase.searchhistory

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.repository.SearchHistoryRepository
import io.reactivex.Single
import javax.inject.Inject

class GetSearchHistoryListUseCase @Inject constructor(
    private val searchHistoryRepository: SearchHistoryRepository
) : BaseUseCase<Single<List<String>>>() {

    override fun buildUseCaseObservable(): Single<List<String>> {
        return searchHistoryRepository.getSearchHistoryList()
    }
}