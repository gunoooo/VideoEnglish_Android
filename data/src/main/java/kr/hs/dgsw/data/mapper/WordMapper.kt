package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.WordEntity
import kr.hs.dgsw.domain.model.Word

class WordMapper : BaseEntityMapper<Word, WordEntity> {

    override fun mapToModel(entity: WordEntity): Word {
        return Word(
            entity.english,
            entity.korean
        )
    }

    override fun mapToEntity(model: Word): WordEntity {
        return WordEntity(
            model.english,
            model.korean
        )
    }
}