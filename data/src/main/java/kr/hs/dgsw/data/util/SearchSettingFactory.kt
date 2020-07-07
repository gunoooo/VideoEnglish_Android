package kr.hs.dgsw.data.util

import kr.hs.dgsw.data.util.Constants.KI_CHANNEL_ID
import kr.hs.dgsw.data.util.Constants.ORANGE_CHANNEL_ID
import kr.hs.dgsw.data.util.Constants.PINE6_CHANNEL_ID
import kr.hs.dgsw.data.util.Constants.SKY_CHANNEL_ID
import kr.hs.dgsw.domain.model.SearchSetting

object SearchSettingFactory {

    fun getBaseSearchSetting(): List<SearchSetting> {
        return listOf(
            SearchSetting(
                    ORANGE_CHANNEL_ID,
                "orange jellybean",
                5
            )

        )
    }

    fun getAllSearchSetting(): List<SearchSetting> {
        return listOf(
            SearchSetting(
                    ORANGE_CHANNEL_ID,
                    "orange jellybean",
                    5
            ),
            SearchSetting(
                PINE6_CHANNEL_ID,
                "Pine6 TV",
                5
            ),
            SearchSetting(
                KI_CHANNEL_ID,
                "기몽초",
                5
            ),
            SearchSetting(
                SKY_CHANNEL_ID,
                "CarolinaBlue-sky",
                5
            )
        )
    }
}