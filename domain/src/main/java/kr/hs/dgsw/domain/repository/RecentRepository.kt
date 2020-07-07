package kr.hs.dgsw.domain.repository

import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import io.reactivex.Single

interface RecentRepository {
    fun getRecentList(): Single<List<YoutubeData>>

    fun insertRecent(youtubeData: YoutubeData): Completable
}