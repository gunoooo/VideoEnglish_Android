package kr.hs.dgsw.domain.usecase.word

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Word
import kr.hs.dgsw.domain.repository.WordRepository
import javax.inject.Inject

class InsertWordUseCase @Inject constructor(
    private val wordRepository: WordRepository
) : ParamsUseCase<InsertWordUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return wordRepository.insertWord(params.word)
    }

    data class Params(
        val word: Word
    )
}