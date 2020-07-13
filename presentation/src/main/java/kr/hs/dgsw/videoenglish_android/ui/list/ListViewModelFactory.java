package kr.hs.dgsw.videoenglish_android.ui.list;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import kr.hs.dgsw.domain.usecase.hiding.InsertHidingUseCase;

public class ListViewModelFactory implements ViewModelProvider.Factory {

    private InsertHidingUseCase insertHidingUseCase;

    @Inject
    public ListViewModelFactory(InsertHidingUseCase insertHidingUseCase) {
        this.insertHidingUseCase = insertHidingUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(
                    InsertHidingUseCase.class
            ). newInstance(
                    insertHidingUseCase
            );
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
