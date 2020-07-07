package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.database.entity.FavoritesEntity
import kr.hs.dgsw.data.database.entity.FavoritesWithItemEntity
import kr.hs.dgsw.domain.model.Favorites

class FavoritesMapper {

    private val favoritesItemMapper = FavoritesItemMapper()

    fun mapToModel(entity: FavoritesWithItemEntity): Favorites {
        return Favorites(
            entity.favorites.id,
            entity.favorites.title,
            entity.favorites.createDate,
            entity.favoritesItemList.map { favoritesItemMapper.mapToModel(it) }
        )
    }

    fun mapToEntity(model: Favorites): FavoritesEntity {
        return FavoritesEntity(
            model.title,
            model.createDate
        )
    }
}