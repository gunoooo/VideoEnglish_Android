package kr.hs.dgsw.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kr.hs.dgsw.data.base.BaseDao
import kr.hs.dgsw.data.database.entity.PlaylistEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PlaylistDao : BaseDao<PlaylistEntity> {

    @Query("SELECT * FROM playlist_table WHERE playlistId=:playlistId")
    fun getPlaylistsList(playlistId: String): Single<List<PlaylistEntity>>

    @Query("DELETE FROM playlist_table")
    fun deleteAll(): Completable
}