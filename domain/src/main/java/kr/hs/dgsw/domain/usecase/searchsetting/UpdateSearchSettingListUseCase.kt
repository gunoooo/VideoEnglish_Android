package kr.hs.dgsw.domain.usecase.searchsetting

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.SearchSetting
import kr.hs.dgsw.domain.repository.SearchSettingRepository
import io.reactivex.Completable
import javax.inject.Inject

class UpdateSearchSettingListUseCase @Inject constructor(
    private val searchSettingRepository: SearchSettingRepository
) : ParamsUseCase<UpdateSearchSettingListUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return searchSettingRepository.updateSearchSettingList(params.searchSettingList)
    }

    data class Params(
        val searchSettingList: List<SearchSetting>
    )
}