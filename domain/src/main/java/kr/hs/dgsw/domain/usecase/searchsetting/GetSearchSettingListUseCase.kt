package kr.hs.dgsw.domain.usecase.searchsetting

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.SearchSetting
import kr.hs.dgsw.domain.repository.SearchSettingRepository
import io.reactivex.Single
import javax.inject.Inject

class GetSearchSettingListUseCase @Inject constructor(
    private val searchSettingRepository: SearchSettingRepository
) : BaseUseCase<Single<List<SearchSetting>>>() {

    override fun buildUseCaseObservable(): Single<List<SearchSetting>> {
        return searchSettingRepository.getSearchSettingList()
    }
}