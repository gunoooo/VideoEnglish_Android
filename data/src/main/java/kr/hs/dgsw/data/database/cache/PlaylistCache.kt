package kr.hs.dgsw.data.database.cache

import android.app.Application
import androidx.room.EmptyResultSetException
import kr.hs.dgsw.data.base.BaseCache
import kr.hs.dgsw.data.database.entity.PlaylistEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PlaylistCache @Inject constructor(application: Application) : BaseCache(application) {

    private val playlistsDao = database.playlistsDao()

    fun getPlaylistsList(playlistId: String): Single<List<PlaylistEntity>> =
        playlistsDao.getPlaylistsList(playlistId)
            .flatMap {
                if (it.isEmpty()) Single.error(EmptyResultSetException("Playlist table is empty"))
                else Single.just(it)
            }

    fun insertPlaylistsList(playlistEntityList: List<PlaylistEntity>): Completable = playlistsDao.insert(playlistEntityList)

    fun deleteAll(): Completable = playlistsDao.deleteAll()
}