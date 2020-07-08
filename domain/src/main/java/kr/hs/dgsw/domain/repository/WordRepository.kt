package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.Word

interface WordRepository {
    fun getWordList(): Single<List<Word>>
    fun insertWord(word: Word): Completable
}