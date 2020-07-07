package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.FavoritesItemEntity
import kr.hs.dgsw.domain.model.YoutubeData

class FavoritesItemMapper : BaseEntityMapper<YoutubeData, FavoritesItemEntity> {

    override fun mapToModel(entity: FavoritesItemEntity): YoutubeData {
        return YoutubeData(
            entity.videoId,
            entity.thumbnailUrl,
            entity.videoTitle,
            entity.channelTitle
        )
    }

    override fun mapToEntity(model: YoutubeData): FavoritesItemEntity {
        return FavoritesItemEntity(
            0,
            model.videoId!!,
            model.thumbnailUrl,
            model.videoTitle,
            model.channelTitle
        )
    }

    fun mapToEntity(model: YoutubeData, favoritesId: Int): FavoritesItemEntity {
        return FavoritesItemEntity(
            favoritesId,
            model.videoId!!,
            model.thumbnailUrl,
            model.videoTitle,
            model.channelTitle
        )
    }
}