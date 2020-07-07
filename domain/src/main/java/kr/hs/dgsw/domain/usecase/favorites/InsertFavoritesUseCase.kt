package kr.hs.dgsw.domain.usecase.favorites

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Favorites
import kr.hs.dgsw.domain.util.yearDateWeekFormat
import io.reactivex.Completable
import kr.hs.dgsw.domain.repository.FavoritesRepository
import java.util.*
import javax.inject.Inject

class InsertFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ParamsUseCase<InsertFavoritesUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return favoritesRepository.insertFavorites(Favorites(params.title, Date().yearDateWeekFormat()))
    }

    data class Params(
        val title: String
    )
}