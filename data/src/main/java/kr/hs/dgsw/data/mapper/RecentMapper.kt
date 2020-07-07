package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.RecentEntity
import kr.hs.dgsw.domain.model.YoutubeData

class RecentMapper : BaseEntityMapper<YoutubeData, RecentEntity> {

    override fun mapToModel(entity: RecentEntity): YoutubeData {
        return YoutubeData(
            entity.videoId,
            entity.thumbnailUrl,
            entity.videoTitle,
            entity.channelTitle
        )
    }

    override fun mapToEntity(model: YoutubeData): RecentEntity {
        return RecentEntity(
            model.videoId!!,
            model.thumbnailUrl,
            model.videoTitle,
            model.channelTitle
        )
    }
}