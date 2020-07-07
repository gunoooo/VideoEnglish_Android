package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.HidingCache
import kr.hs.dgsw.data.mapper.HidingMapper
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.YoutubeData
import javax.inject.Inject

class HidingDataSource @Inject constructor(
    override val remote: Any,
    override val cache: HidingCache
): BaseDataSource<Any, HidingCache>() {

    private val hidingMapper = HidingMapper()

    fun getHidingList(): Single<List<YoutubeData>> = cache.getHidingList().map { hidingEntityList -> hidingEntityList.map { hidingMapper.mapToModel(it) } }

    fun insertHiding(youtubeData: YoutubeData): Completable = cache.insertHiding(hidingMapper.mapToEntity(youtubeData))

    fun deleteHiding(youtubeData: YoutubeData): Completable = cache.deleteHiding(hidingMapper.mapToEntity(youtubeData))
}