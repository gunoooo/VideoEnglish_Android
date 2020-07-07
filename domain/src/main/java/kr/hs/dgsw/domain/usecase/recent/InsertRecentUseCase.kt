package kr.hs.dgsw.domain.usecase.recent

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import kr.hs.dgsw.domain.repository.RecentRepository
import javax.inject.Inject

class InsertRecentUseCase @Inject constructor(
    private val recentRepository: RecentRepository
) : ParamsUseCase<InsertRecentUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return recentRepository.insertRecent(params.youtubeData)
    }

    data class Params(
        val youtubeData: YoutubeData
    )
}