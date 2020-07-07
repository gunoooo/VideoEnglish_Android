package kr.hs.dgsw.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.FavoritesItemEntity
import io.reactivex.Single

@Dao
interface FavoritesItemDao : BaseDao<FavoritesItemEntity> {

    @Query("SELECT * FROM favorites_item_table")
    fun getFavoritesItemList(): Single<List<FavoritesItemEntity>>
}