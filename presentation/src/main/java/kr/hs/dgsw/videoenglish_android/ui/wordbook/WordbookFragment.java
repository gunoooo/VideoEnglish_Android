package kr.hs.dgsw.videoenglish_android.ui.wordbook;

import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentWordbookBinding;

public class WordbookFragment extends BaseFragment<FragmentWordbookBinding, WordbookViewModel> {

    @NotNull
    @Override
    protected WordbookViewModel getViewModel() {
        return new ViewModelProvider(this).get(WordbookViewModel.class);
    }

    @Override
    protected void observerViewModel() {

    }
}
