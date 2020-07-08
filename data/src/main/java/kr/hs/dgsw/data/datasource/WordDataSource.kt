package kr.hs.dgsw.data.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.cache.WordCache
import kr.hs.dgsw.data.mapper.WordMapper
import kr.hs.dgsw.domain.model.Word
import javax.inject.Inject

class WordDataSource @Inject constructor(
    override val remote: Any,
    override val cache: WordCache
) : BaseDataSource<Any, WordCache>() {

    private val wordMapper = WordMapper()

    fun getWordList(): Single<List<Word>> =
            cache.getWordList().map { wordEntityList ->
                wordEntityList.map { wordMapper.mapToModel(it) }}

    fun insertWord(word: Word): Completable =
            cache.insertWord(wordMapper.mapToEntity(word))
}