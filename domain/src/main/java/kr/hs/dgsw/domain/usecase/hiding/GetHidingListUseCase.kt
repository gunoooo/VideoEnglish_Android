package kr.hs.dgsw.domain.usecase.hiding

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.HidingRepository
import io.reactivex.Single
import javax.inject.Inject

class GetHidingListUseCase @Inject constructor(
    private val hidingRepository: HidingRepository
) : BaseUseCase<Single<List<YoutubeData>>>() {

    override fun buildUseCaseObservable(): Single<List<YoutubeData>> {
        return hidingRepository.getHidingList()
    }
}