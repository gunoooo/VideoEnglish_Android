package com.gunwoo.karaoke.domain.usecase.favorites

import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import kr.hs.dgsw.domain.repository.FavoritesRepository
import javax.inject.Inject

class InsertFavoritesItemUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ParamsUseCase<InsertFavoritesItemUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return favoritesRepository.insertFavoritesItem(params.youtubeData, params.favoritesId)
    }

    data class Params(
            val youtubeData: YoutubeData,
            val favoritesId: Int
    )
}