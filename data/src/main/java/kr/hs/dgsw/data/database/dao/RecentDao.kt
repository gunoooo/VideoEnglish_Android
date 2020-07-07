package kr.hs.dgsw.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.RecentEntity
import io.reactivex.Single

@Dao
interface RecentDao : BaseDao<RecentEntity> {

    @Query("SELECT * FROM recent_table")
    fun getRecentList(): Single<List<RecentEntity>>
}