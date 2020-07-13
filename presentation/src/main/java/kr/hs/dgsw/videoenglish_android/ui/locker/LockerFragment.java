package kr.hs.dgsw.videoenglish_android.ui.locker;

import android.content.Intent;

import androidx.lifecycle.ViewModelProvider;

import kr.hs.dgsw.videoenglish_android.ui.favorites.FavoritesAddDialog;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

import javax.inject.Inject;

import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentLockerBinding;
import kr.hs.dgsw.videoenglish_android.ui.list.ListActivity;
import kr.hs.dgsw.videoenglish_android.ui.player.PlayerActivity;

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

        mViewModel.recentListAdapter.getOnClickItemEvent().observe(this, youtubeData -> {
            startActivity(
                    new Intent(requireContext().getApplicationContext(), PlayerActivity.class)
                            .putExtra(PlayerActivity.EXTRA_VIDEO, youtubeData)
                            .putExtra(PlayerActivity.EXTRA_VIDEO_LIST, (Serializable) mViewModel.recentList)
            );
        });

        mViewModel.favoritesListAdapter.getOnClickItemEvent().observe(this, favorites -> {
            startActivity(
                    new Intent(requireContext().getApplicationContext(), ListActivity.class)
                            .putExtra(ListActivity.EXTRA_TITLE, favorites.getTitle())
                            .putExtra(ListActivity.EXTRA_VIDEO_LIST, (Serializable) favorites.getFavoritesItemList())
            );
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.setRecentList();
        mViewModel.setFavoritesList();
    }
}
