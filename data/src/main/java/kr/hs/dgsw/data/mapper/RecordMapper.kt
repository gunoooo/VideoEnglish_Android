package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.data.database.entity.RecordEntity
import kr.hs.dgsw.domain.model.Record
import java.io.File

class RecordMapper : BaseEntityMapper<Record, RecordEntity> {

    override fun mapToModel(entity: RecordEntity): Record {
        return Record(
            entity.title,
            entity.time,
            entity.thumbnail,
            File(entity.path)
        )
    }

    override fun mapToEntity(model: Record): RecordEntity {
        return RecordEntity(
            model.title,
            model.thumbnail,
            model.time,
            model.file.absolutePath
        )
    }
}