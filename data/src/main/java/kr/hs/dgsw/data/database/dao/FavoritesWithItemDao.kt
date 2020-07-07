package com.gunwoo.karaoke.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.FavoritesItemEntity
import kr.hs.dgsw.data.database.entity.FavoritesWithItemEntity
import io.reactivex.Single

@Dao
interface FavoritesWithItemDao : BaseDao<FavoritesItemEntity> {

    @Query("SELECT * FROM favorites_table")
    fun getFavoritesWithItemList(): Single<List<FavoritesWithItemEntity>>
}