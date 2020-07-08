package kr.hs.dgsw.videoenglish_android.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.playlist.GetPlaylistListUseCase;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private GetPlaylistListUseCase getPlaylistListUseCase;

    @Inject
    public HomeViewModelFactory(GetPlaylistListUseCase getPlaylistListUseCase) {
        this.getPlaylistListUseCase = getPlaylistListUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    GetPlaylistListUseCase.class
            ). newInstance(
                    getPlaylistListUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
