package kr.hs.dgsw.videoenglish_android.ui.locker;

import androidx.lifecycle.ViewModelProvider;

import com.gunwoo.karaoke.singsangsung.ui.favorites.FavoritesAddDialog;

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
    @SuppressWarnings("unchecked")
    protected void observerViewModel() {
        mViewModel.getOnOpenFavoritesAddViewEvent().observe(this, o1 -> {
            FavoritesAddDialog favoritesAddDialog = new FavoritesAddDialog();
            favoritesAddDialog.show(LockerFragment.this.getParentFragmentManager());
            favoritesAddDialog.getOnSuccessInsertEvent().observe(this, o2 -> {
                mViewModel.setFavoritesList();
            });
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.setRecentList();
        mViewModel.setFavoritesList();
    }
}
