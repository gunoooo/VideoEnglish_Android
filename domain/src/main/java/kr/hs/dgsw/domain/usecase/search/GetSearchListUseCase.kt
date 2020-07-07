package kr.hs.dgsw.domain.usecase.search

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.SearchRepository
import io.reactivex.Single
import javax.inject.Inject

class GetSearchListUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) : ParamsUseCase<GetSearchListUseCase.Params, Single<List<YoutubeData>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<YoutubeData>> {
        return searchRepository.getSearchList(params.search)
    }

    data class Params(val search: String)
}