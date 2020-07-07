package kr.hs.dgsw.data.repository

import kr.hs.dgsw.data.datasource.SearchSettingDataSource
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.SearchSetting
import kr.hs.dgsw.domain.repository.SearchSettingRepository
import javax.inject.Inject

class SearchSettingRepositoryImpl @Inject constructor(
    private val searchSettingDataSource: SearchSettingDataSource
) : SearchSettingRepository {

    override fun getSearchSettingList(): Single<List<SearchSetting>> {
        return searchSettingDataSource.getSearchSettingList()
    }

    override fun getNotSelectedSearchSettingList(): Single<List<SearchSetting>> {
        return searchSettingDataSource.getNotSelectedSearchSettingList()
    }

    override fun insertSearchSetting(searchSetting: SearchSetting): Completable {
        return searchSettingDataSource.insertSearchSetting(searchSetting)
    }

    override fun deleteSearchSetting(searchSetting: SearchSetting): Completable {
        return searchSettingDataSource.deleteSearchSetting(searchSetting)
    }

    override fun updateSearchSetting(searchSetting: SearchSetting): Completable {
        return searchSettingDataSource.updateSearchSetting(searchSetting)
    }

    override fun updateSearchSettingList(searchSettingList: List<SearchSetting>): Completable {
        return searchSettingDataSource.updateSearchSettingList(searchSettingList)
    }
}