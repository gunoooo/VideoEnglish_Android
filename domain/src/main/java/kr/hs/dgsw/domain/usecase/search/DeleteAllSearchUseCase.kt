package kr.hs.dgsw.domain.usecase.search

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.repository.SearchRepository
import io.reactivex.Completable
import javax.inject.Inject

class DeleteAllSearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) : BaseUseCase<Completable>() {

    override fun buildUseCaseObservable(): Completable {
        return searchRepository.deleteAllSearch()
    }
}