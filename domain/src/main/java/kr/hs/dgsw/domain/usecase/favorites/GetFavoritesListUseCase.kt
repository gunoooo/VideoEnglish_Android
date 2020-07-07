package kr.hs.dgsw.domain.usecase.favorites

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Favorites
import kr.hs.dgsw.domain.repository.FavoritesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetFavoritesListUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ParamsUseCase<GetFavoritesListUseCase.Params, Single<List<Favorites>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<Favorites>> {
        return if (params.videoId == null)
            favoritesRepository.getFavoritesList()
        else
            favoritesRepository.getFavoritesList(params.videoId)
    }

    data class Params(
        val videoId: String?
    ) {
        constructor() : this(null)
    }
}