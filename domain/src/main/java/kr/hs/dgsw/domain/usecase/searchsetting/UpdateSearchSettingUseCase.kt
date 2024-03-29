package kr.hs.dgsw.domain.usecase.searchsetting

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.SearchSetting
import kr.hs.dgsw.domain.repository.SearchSettingRepository
import io.reactivex.Completable
import javax.inject.Inject

class UpdateSearchSettingUseCase @Inject constructor(
    private val searchSettingRepository: SearchSettingRepository
) : ParamsUseCase<UpdateSearchSettingUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return searchSettingRepository.updateSearchSetting(params.searchSetting)
    }

    data class Params(
        val searchSetting: SearchSetting
    )
}