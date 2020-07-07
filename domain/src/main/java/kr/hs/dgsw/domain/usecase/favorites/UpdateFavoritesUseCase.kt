package kr.hs.dgsw.domain.usecase.favorites

import kr.hs.dgsw.domain.base.ParamsUseCase
import io.reactivex.Completable
import kr.hs.dgsw.domain.repository.FavoritesRepository
import javax.inject.Inject

class UpdateFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ParamsUseCase<UpdateFavoritesUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return favoritesRepository.updateFavorites(params.favoritesId, params.favoritesTitle)
    }

    data class Params(
        val favoritesId: Int,
        val favoritesTitle: String
    )
}