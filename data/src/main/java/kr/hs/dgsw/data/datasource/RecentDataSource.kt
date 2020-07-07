package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.RecentCache
import kr.hs.dgsw.data.mapper.RecentMapper
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.YoutubeData
import javax.inject.Inject

class RecentDataSource @Inject constructor(
    override val remote: Any,
    override val cache: RecentCache
): BaseDataSource<Any, RecentCache>() {

    private val recentMapper = RecentMapper()

    fun getRecentList(): Single<List<YoutubeData>> =
        cache.getRecentList()
            .map { recentEntityList -> recentEntityList.sortedByDescending { it.idx } }
            .map { recentList -> recentList.map { recentMapper.mapToModel(it) } }

    fun insertRecent(youtubeData: YoutubeData): Completable = cache.insertRecent(recentMapper.mapToEntity(youtubeData))
}