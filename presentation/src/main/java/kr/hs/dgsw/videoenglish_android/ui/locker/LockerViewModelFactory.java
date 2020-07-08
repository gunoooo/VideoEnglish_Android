package kr.hs.dgsw.videoenglish_android.ui.locker;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.favorites.GetFavoritesListUseCase;
import kr.hs.dgsw.domain.usecase.recent.GetRecentListUseCase;

public class LockerViewModelFactory implements ViewModelProvider.Factory {

    private GetRecentListUseCase getRecentListUseCase;
    private GetFavoritesListUseCase getFavoritesListUseCase;

    @Inject
    public LockerViewModelFactory(GetRecentListUseCase getRecentListUseCase,
                                  GetFavoritesListUseCase getFavoritesListUseCase) {
        this.getRecentListUseCase = getRecentListUseCase;
        this.getFavoritesListUseCase = getFavoritesListUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    GetRecentListUseCase.class,
                    GetFavoritesListUseCase.class
            ). newInstance(
                    getRecentListUseCase,
                    getFavoritesListUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}