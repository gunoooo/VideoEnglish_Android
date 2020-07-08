package kr.hs.dgsw.data.database.entity

import androidx.room.Entity

@Entity(tableName = "word_table",
    primaryKeys = ["english", "korean"])
data class WordEntity(
    val english: String,
    val korean: String
)