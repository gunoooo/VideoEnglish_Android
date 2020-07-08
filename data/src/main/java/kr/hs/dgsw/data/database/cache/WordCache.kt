package kr.hs.dgsw.data.database.cache

import android.app.Application
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseCache
import kr.hs.dgsw.data.database.entity.WordEntity
import javax.inject.Inject

class WordCache @Inject constructor(application: Application) : BaseCache(application) {

    private val wordDao = database.wordDao()

    fun getWordList(): Single<List<WordEntity>> = wordDao.getWordList()

    fun insertWord(wordEntity: WordEntity) = wordDao.insert(wordEntity)
}