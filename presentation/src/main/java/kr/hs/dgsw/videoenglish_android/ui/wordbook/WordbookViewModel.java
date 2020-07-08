package kr.hs.dgsw.videoenglish_android.ui.wordbook;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import kr.hs.dgsw.domain.model.Word;
import kr.hs.dgsw.domain.usecase.word.GetWordListUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.word.WordListAdapter;

public class WordbookViewModel extends BaseViewModel {

    private GetWordListUseCase getWordListUseCase;

    public WordbookViewModel(GetWordListUseCase getWordListUseCase) {
        this.getWordListUseCase = getWordListUseCase;
        setWordList();
    }

    private List<Word> wordList = new ArrayList<>();
    public WordListAdapter wordListAdapter = new WordListAdapter(wordList);

    private void setWordList() {
        addDisposable(getWordListUseCase.buildUseCaseObservable(),
                new DisposableSingleObserver<List<Word>>() {
                    @Override
                    public void onSuccess(List<Word> words) {
                        wordList.clear();
                        wordList.addAll(words);
                        wordListAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
    }
}
