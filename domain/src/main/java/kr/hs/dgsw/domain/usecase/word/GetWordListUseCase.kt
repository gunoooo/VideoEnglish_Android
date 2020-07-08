package kr.hs.dgsw.domain.usecase.word

import io.reactivex.Single
import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.Word
import kr.hs.dgsw.domain.repository.WordRepository
import javax.inject.Inject

class GetWordListUseCase @Inject constructor(
    private val wordRepository: WordRepository
) : BaseUseCase<Single<List<Word>>>() {

    override fun buildUseCaseObservable(): Single<List<Word>> {
        return wordRepository.getWordList()
    }
}