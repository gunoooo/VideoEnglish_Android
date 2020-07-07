package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.FavoritesCache
import kr.hs.dgsw.data.mapper.FavoritesMapper
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.Favorites
import javax.inject.Inject

class FavoritesDataSource @Inject constructor(
    override val remote: Any,
    override val cache: FavoritesCache
): BaseDataSource<Any, FavoritesCache>() {

    private val favoritesMapper = FavoritesMapper()

    fun getFavoritesList(): Single<List<Favorites>> =
        cache.getFavoritesWithItemList().map { favoritesWithItemEntityList -> favoritesWithItemEntityList.map { favoritesMapper.mapToModel(it) } }

    fun insertFavorites(favorites: Favorites): Completable =
        cache.insertFavorites(favoritesMapper.mapToEntity(favorites))

    fun updateFavorites(id: Int, title: String): Completable =
        cache.updateFavorites(id, title)

    fun deleteFavorites(id: Int): Completable =
        cache.deleteFavorites(id)
}