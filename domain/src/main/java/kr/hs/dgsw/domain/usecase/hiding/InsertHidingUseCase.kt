package kr.hs.dgsw.domain.usecase.hiding

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.HidingRepository
import io.reactivex.Completable
import javax.inject.Inject

class InsertHidingUseCase @Inject constructor(
    private val hidingRepository: HidingRepository
) : ParamsUseCase<InsertHidingUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return hidingRepository.insertHiding(params.youtubeData)
    }

    data class Params(
        val youtubeData: YoutubeData
    )
}