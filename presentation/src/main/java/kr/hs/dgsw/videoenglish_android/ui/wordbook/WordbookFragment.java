package kr.hs.dgsw.videoenglish_android.ui.wordbook;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentWordbookBinding;

public class WordbookFragment extends BaseFragment<FragmentWordbookBinding, WordbookViewModel> {

    @Inject
    WordbookViewModelFactory viewModelFactory;

    @NotNull
    @Override
    protected WordbookViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(WordbookViewModel.class);
    }

    @Override
    protected void observerViewModel() {

    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.wordRecyclerview.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
    }
}
