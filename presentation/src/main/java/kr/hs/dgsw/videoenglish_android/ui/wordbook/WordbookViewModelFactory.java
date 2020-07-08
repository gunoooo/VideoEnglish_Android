package kr.hs.dgsw.videoenglish_android.ui.wordbook;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.word.GetWordListUseCase;

public class WordbookViewModelFactory implements ViewModelProvider.Factory {

    private GetWordListUseCase getWordListUseCase;

    @Inject
    public WordbookViewModelFactory(GetWordListUseCase getWordListUseCase) {
        this.getWordListUseCase = getWordListUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    GetWordListUseCase.class
            ). newInstance(
                    getWordListUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
