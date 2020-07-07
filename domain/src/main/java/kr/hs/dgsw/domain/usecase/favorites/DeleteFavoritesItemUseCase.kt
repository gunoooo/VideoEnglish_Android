package kr.hs.dgsw.domain.usecase.favorites

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import kr.hs.dgsw.domain.repository.FavoritesRepository
import javax.inject.Inject

class DeleteFavoritesItemUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ParamsUseCase<DeleteFavoritesItemUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return favoritesRepository.deleteFavoritesItem(params.youtubeData, params.favoritesId)
    }

    data class Params(
            val youtubeData: YoutubeData,
            val favoritesId: Int
    )
}