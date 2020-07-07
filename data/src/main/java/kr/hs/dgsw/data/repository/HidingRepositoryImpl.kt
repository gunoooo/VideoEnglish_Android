package kr.hs.dgsw.data.repository

import kr.hs.dgsw.data.datasource.HidingDataSource
import com.gunwoo.karaoke.data.exception.ListEmptyException
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.repository.HidingRepository
import javax.inject.Inject

class HidingRepositoryImpl @Inject constructor(
        private val hidingDataSource: HidingDataSource
) : HidingRepository {

    override fun getHidingList(): Single<List<YoutubeData>> {
        return hidingDataSource.getHidingList().map { if (it.isEmpty()) throw ListEmptyException("숨김 리스트가 없습니다") else it }
    }

    override fun insertHiding(youtubeData: YoutubeData): Completable {
        return hidingDataSource.insertHiding(youtubeData)
    }

    override fun deleteHiding(youtubeData: YoutubeData): Completable {
        return hidingDataSource.deleteHiding(youtubeData)
    }
}