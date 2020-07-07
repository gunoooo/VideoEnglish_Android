package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.SearchEntity
import kr.hs.dgsw.domain.model.Search
import kr.hs.dgsw.domain.model.YoutubeData

class SearchMapper : BaseEntityMapper<Search, SearchEntity> {

    override fun mapToModel(entity: SearchEntity): Search {
        return Search(
            entity.searchVideoId,
            entity.videoId,
            entity.channelId,
            entity.search,
            entity.thumbnailUrl,
            entity.videoTitle,
            entity.channelTitle
        )
    }

    override fun mapToEntity(model: Search): SearchEntity {
        return SearchEntity(
            model.searchVideoId,
            model.videoId,
            model.channelId,
            model.search,
            model.thumbnailUrl,
            model.videoTitle,
            model.channelTitle
        )
    }

    fun mapToYoutubeData(entity: SearchEntity): YoutubeData {
        return YoutubeData(
            entity.videoId,
            entity.thumbnailUrl,
            entity.videoTitle,
            entity.channelTitle,
            null,
            entity.channelId,
            entity.search
        )
    }
}