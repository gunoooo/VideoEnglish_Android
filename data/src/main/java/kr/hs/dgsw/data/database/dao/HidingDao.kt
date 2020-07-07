package kr.hs.dgsw.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.HidingEntity
import io.reactivex.Single

@Dao
interface HidingDao : BaseDao<HidingEntity> {

    @Query("SELECT * FROM hiding_table")
    fun getHidingList(): Single<List<HidingEntity>>
}