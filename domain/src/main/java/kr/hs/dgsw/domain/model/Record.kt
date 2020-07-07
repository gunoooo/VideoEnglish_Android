package kr.hs.dgsw.domain.model

import java.io.File

data class Record(
    val title: String,
    val time: String,
    val thumbnail: String,
    val file: File
)