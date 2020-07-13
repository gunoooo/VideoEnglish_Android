package kr.hs.dgsw.videoenglish_android.ui.splash;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.playlist.InsertDefaultPlaylistUseCase;

public class SplashViewModelFactory implements ViewModelProvider.Factory {

    private InsertDefaultPlaylistUseCase insertDefaultPlaylistUseCase;

    @Inject
    public SplashViewModelFactory(InsertDefaultPlaylistUseCase insertDefaultPlaylistUseCase) {
        this.insertDefaultPlaylistUseCase = insertDefaultPlaylistUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    InsertDefaultPlaylistUseCase.class
            ). newInstance(
                    insertDefaultPlaylistUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
