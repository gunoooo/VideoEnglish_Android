package kr.hs.dgsw.videoenglish_android.ui.locker;

import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentLockerBinding;

public class LockerFragment extends BaseFragment<FragmentLockerBinding, LockerViewModel> {

    @NotNull
    @Override
    protected LockerViewModel getViewModel() {
        return new ViewModelProvider(this).get(LockerViewModel.class);
    }

    @Override
    protected void observerViewModel() {

    }
}
