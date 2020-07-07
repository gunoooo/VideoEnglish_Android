package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.SearchSettingEntity
import kr.hs.dgsw.domain.model.SearchSetting

class SearchSettingMapper : BaseEntityMapper<SearchSetting, SearchSettingEntity> {

    override fun mapToModel(entity: SearchSettingEntity): SearchSetting {
        return SearchSetting(
            entity.channelId,
            entity.channelTitle,
            entity.maxResults
        )
    }

    override fun mapToEntity(model: SearchSetting): SearchSettingEntity {
        return SearchSettingEntity(
            model.channelId,
            model.channelTitle,
            model.maxResults
        )
    }
}