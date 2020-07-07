package kr.hs.dgsw.domain.repository

import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import io.reactivex.Single

interface HidingRepository {
    fun getHidingList(): Single<List<YoutubeData>>

    fun insertHiding(youtubeData: YoutubeData): Completable

    fun deleteHiding(youtubeData: YoutubeData): Completable
}