package kr.hs.dgsw.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.RecordEntity
import io.reactivex.Single

@Dao
interface RecordDao : BaseDao<RecordEntity> {

    @Query("SELECT * FROM record_table")
    fun getRecordList(): Single<List<RecordEntity>>
}