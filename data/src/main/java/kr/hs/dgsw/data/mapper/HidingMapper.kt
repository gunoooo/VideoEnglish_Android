package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.HidingEntity
import kr.hs.dgsw.domain.model.YoutubeData

class HidingMapper : BaseEntityMapper<YoutubeData, HidingEntity> {

    override fun mapToModel(entity: HidingEntity): YoutubeData {
        val model = YoutubeData(
            entity.videoId,
            entity.thumbnailUrl,
            entity.videoTitle,
            entity.channelTitle
        )
        model.isHiding = true
        return model
    }

    override fun mapToEntity(model: YoutubeData): HidingEntity {
        return HidingEntity(
            model.videoId!!,
            model.thumbnailUrl,
            model.videoTitle,
            model.channelTitle
        )
    }
}