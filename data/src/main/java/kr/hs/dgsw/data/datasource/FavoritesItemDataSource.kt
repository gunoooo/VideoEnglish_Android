package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.FavoritesItemCache
import kr.hs.dgsw.data.mapper.FavoritesItemMapper
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.YoutubeData
import javax.inject.Inject

class FavoritesItemDataSource @Inject constructor(
    override val remote: Any,
    override val cache: FavoritesItemCache
): BaseDataSource<Any, FavoritesItemCache>() {

    private val favoritesItemMapper = FavoritesItemMapper()

    fun getFavoritesItemList(): Single<List<YoutubeData>> =
        cache.getFavoritesItemList().map { favoritesItemList -> favoritesItemList.map { favoritesItemMapper.mapToModel(it) } }

    fun insertFavoritesItem(youtubeData: YoutubeData, favoritesId: Int): Completable =
        cache.insertFavoritesItem(favoritesItemMapper.mapToEntity(youtubeData, favoritesId))

    fun deleteFavoritesItem(youtubeData: YoutubeData, favoritesId: Int): Completable =
        cache.deleteFavoritesItem(favoritesItemMapper.mapToEntity(youtubeData, favoritesId))
}