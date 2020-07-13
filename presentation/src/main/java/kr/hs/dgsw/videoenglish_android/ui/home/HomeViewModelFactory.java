package kr.hs.dgsw.videoenglish_android.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.hiding.InsertHidingUseCase;
import kr.hs.dgsw.domain.usecase.playlist.GetDefaultPlaylistListUseCase;
import kr.hs.dgsw.domain.usecase.playlist.GetPlaylistListUseCase;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private GetDefaultPlaylistListUseCase getDefaultPlaylistListUseCase;
    private InsertHidingUseCase insertHidingUseCase;

    @Inject
    public HomeViewModelFactory(GetDefaultPlaylistListUseCase getDefaultPlaylistListUseCase,
                                InsertHidingUseCase insertHidingUseCase) {
        this.getDefaultPlaylistListUseCase = getDefaultPlaylistListUseCase;
        this.insertHidingUseCase = insertHidingUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    GetDefaultPlaylistListUseCase.class,
                    InsertHidingUseCase.class
            ). newInstance(
                    getDefaultPlaylistListUseCase,
                    insertHidingUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
