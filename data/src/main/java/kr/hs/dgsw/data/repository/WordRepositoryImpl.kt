package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.datasource.WordDataSource
import kr.hs.dgsw.domain.model.Word
import kr.hs.dgsw.domain.repository.WordRepository
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
        private val wordDataSource: WordDataSource
) : WordRepository {

    override fun getWordList(): Single<List<Word>> {
        return wordDataSource.getWordList()
    }

    override fun insertWord(word: Word): Completable {
        return wordDataSource.insertWord(word)
    }
}