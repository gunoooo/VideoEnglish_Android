package kr.hs.dgsw.data.database.cache

import android.app.Application
import kr.hs.dgsw.data.base.BaseCache
import kr.hs.dgsw.data.database.entity.FavoritesItemEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class FavoritesItemCache @Inject constructor(application: Application) : BaseCache(application) {

    private val favoritesDao = database.favoritesItemDao()

    fun getFavoritesItemList(): Single<List<FavoritesItemEntity>> = favoritesDao.getFavoritesItemList()

    fun insertFavoritesItem(favoritesItemEntity: FavoritesItemEntity): Completable = favoritesDao.insert(favoritesItemEntity)

    fun deleteFavoritesItem(favoritesItemEntity: FavoritesItemEntity): Completable = favoritesDao.delete(favoritesItemEntity)
}