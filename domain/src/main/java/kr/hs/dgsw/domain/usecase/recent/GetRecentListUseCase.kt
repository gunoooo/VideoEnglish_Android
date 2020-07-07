package kr.hs.dgsw.domain.usecase.recent

import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.RecentRepository
import io.reactivex.Single
import javax.inject.Inject

class GetRecentListUseCase @Inject constructor(
    private val recentRepository: RecentRepository
) : BaseUseCase<Single<List<YoutubeData>>>() {

    override fun buildUseCaseObservable(): Single<List<YoutubeData>> {
        return recentRepository.getRecentList()
    }
}