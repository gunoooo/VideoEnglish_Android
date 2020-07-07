package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.SearchSettingCache
import kr.hs.dgsw.data.mapper.SearchSettingMapper
import kr.hs.dgsw.data.util.SearchSettingFactory
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.SearchSetting
import javax.inject.Inject

class SearchSettingDataSource @Inject constructor(
    override val remote: Any,
    override val cache: SearchSettingCache
) : BaseDataSource<Any, SearchSettingCache>() {

    private val searchSettingMapper = SearchSettingMapper()

    fun getSearchSettingList(): Single<List<SearchSetting>> =
        cache.getSearchSettingList()
            .onErrorResumeNext {
                val baseSearchSettingList = SearchSettingFactory.getBaseSearchSetting()
                insertSearchSettingList(baseSearchSettingList).toSingleDefault(baseSearchSettingList.map { searchSettingMapper.mapToEntity(it) }) }
            .map { searchSettingEntityList -> searchSettingEntityList.map { searchSettingMapper.mapToModel(it) } }

    fun getNotSelectedSearchSettingList(): Single<List<SearchSetting>> =
        getSearchSettingList().map { searchSettingList -> SearchSettingFactory.getAllSearchSetting()
            .filter { it.channelId !in searchSettingList.map { searchSetting -> searchSetting.channelId } } }

    fun insertSearchSetting(searchSetting: SearchSetting): Completable = cache.insertSearchSetting(searchSettingMapper.mapToEntity(searchSetting))

    fun deleteSearchSetting(searchSetting: SearchSetting): Completable = cache.deleteSearchSetting(searchSettingMapper.mapToEntity(searchSetting))

    fun updateSearchSetting(searchSetting: SearchSetting): Completable = cache.updateSearchSetting(searchSettingMapper.mapToEntity(searchSetting))

    fun updateSearchSettingList(searchSettingList: List<SearchSetting>): Completable = deleteAll().andThen(insertSearchSettingList(searchSettingList))

    private fun insertSearchSettingList(searchSettingList: List<SearchSetting>): Completable =
        cache.insertSearchSettingList(searchSettingList.map { searchSettingMapper.mapToEntity(it) })

    fun deleteAll(): Completable = cache.deleteAll()
}