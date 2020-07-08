package kr.hs.dgsw.videoenglish_android.ui.locker;

import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentLockerBinding;

public class LockerFragment extends BaseFragment<FragmentLockerBinding, LockerViewModel> {

    @Inject
    LockerViewModelFactory viewModelFactory;

    @NotNull
    @Override
    protected LockerViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(LockerViewModel.class);
    }

    @Override
    protected void observerViewModel() {

    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.setRecentList();
        mViewModel.setFavoritesList();
    }
}
