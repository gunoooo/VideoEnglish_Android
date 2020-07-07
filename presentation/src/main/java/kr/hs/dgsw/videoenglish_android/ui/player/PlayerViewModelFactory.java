package kr.hs.dgsw.videoenglish_android.ui.player;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.recent.InsertRecentUseCase;

public class PlayerViewModelFactory implements ViewModelProvider.Factory {

    private InsertRecentUseCase insertRecentUseCase;

    @Inject
    PlayerViewModelFactory(InsertRecentUseCase insertRecentUseCase) {
        this.insertRecentUseCase = insertRecentUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    InsertRecentUseCase.class
            ). newInstance(
                    insertRecentUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
