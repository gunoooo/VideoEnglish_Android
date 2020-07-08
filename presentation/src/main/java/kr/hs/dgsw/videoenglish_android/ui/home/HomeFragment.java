package kr.hs.dgsw.videoenglish_android.ui.home;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

import javax.inject.Inject;

import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentHomeBinding;
import kr.hs.dgsw.videoenglish_android.ui.player.PlayerActivity;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    @Inject
    HomeViewModelFactory viewModelFactory;

    @NotNull
    @Override
    protected HomeViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(HomeViewModel.class);
    }

    @Override
    protected void observerViewModel() {
        mViewModel.videoListAdapter.getOnClickItemEvent().observe(this, youtubeData ->
                startActivity(
                        new Intent(requireContext().getApplicationContext(), PlayerActivity.class)
                                .putExtra(PlayerActivity.EXTRA_VIDEO, youtubeData)
                                .putExtra(PlayerActivity.EXTRA_VIDEO_LIST, (Serializable) mViewModel.videoList)
                )
        );
    }
}
