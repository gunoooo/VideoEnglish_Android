package kr.hs.dgsw.domain.repository

import kr.hs.dgsw.domain.model.YoutubeData
import io.reactivex.Completable
import io.reactivex.Single

interface SearchRepository {
    fun getSearchList(search: String): Single<List<YoutubeData>>

    fun deleteAllSearch(): Completable
}