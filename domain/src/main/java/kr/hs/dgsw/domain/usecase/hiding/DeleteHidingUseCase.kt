package kr.hs.dgsw.domain.usecase.hiding

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.HidingRepository
import io.reactivex.Completable
import javax.inject.Inject

class DeleteHidingUseCase @Inject constructor(
    private val hidingRepository: HidingRepository
) : ParamsUseCase<DeleteHidingUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return hidingRepository.deleteHiding(params.youtubeData)
    }

    data class Params(
        val youtubeData: YoutubeData
    )
}