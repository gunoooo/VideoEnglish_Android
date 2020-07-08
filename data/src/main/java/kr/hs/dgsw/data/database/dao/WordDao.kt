package kr.hs.dgsw.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.WordEntity

@Dao
interface WordDao: BaseDao<WordEntity> {
    @Query("SELECT * FROM word_table")
    fun getWordList(): Single<List<WordEntity>>
}