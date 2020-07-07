package kr.hs.dgsw.domain.usecase.favorites

import kr.hs.dgsw.domain.base.ParamsUseCase
import io.reactivex.Completable
import kr.hs.dgsw.domain.repository.FavoritesRepository
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ParamsUseCase<DeleteFavoritesUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return favoritesRepository.deleteFavorites(params.favoritesId)
    }

    data class Params(
        val favoritesId: Int
    )
}