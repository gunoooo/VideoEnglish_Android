package kr.hs.dgsw.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hiding_table")
data class HidingEntity(
    @PrimaryKey
    val videoId: String,
    val thumbnailUrl: String?,
    val videoTitle: String,
    val channelTitle: String
)