package kr.hs.dgsw.videoenglish_android.ui.player;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.recent.InsertRecentUseCase;
import kr.hs.dgsw.domain.usecase.word.InsertWordUseCase;

public class PlayerViewModelFactory implements ViewModelProvider.Factory {

    private InsertRecentUseCase insertRecentUseCase;
    private InsertWordUseCase insertWordUseCase;

    @Inject
    public PlayerViewModelFactory(InsertRecentUseCase insertRecentUseCase,
                                  InsertWordUseCase insertWordUseCase) {
        this.insertRecentUseCase = insertRecentUseCase;
        this.insertWordUseCase = insertWordUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    InsertRecentUseCase.class,
                    InsertWordUseCase.class
            ). newInstance(
                    insertRecentUseCase,
                    insertWordUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
