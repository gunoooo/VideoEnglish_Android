package kr.hs.dgsw.domain.model

data class SearchSetting(
    val channelId: String,
    val channelTitle: String,
    var maxResults: Int
)