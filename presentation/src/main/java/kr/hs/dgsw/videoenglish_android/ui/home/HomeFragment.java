package kr.hs.dgsw.videoenglish_android.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

import javax.inject.Inject;

import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.base.BaseFragment;
import kr.hs.dgsw.videoenglish_android.databinding.FragmentHomeBinding;
import kr.hs.dgsw.videoenglish_android.ui.favorites.FavoritesBottomSheetDialog;
import kr.hs.dgsw.videoenglish_android.ui.player.PlayerActivity;
import kr.hs.dgsw.videoenglish_android.ui.splash.SplashActivity;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel>
    implements SwipeRefreshLayout.OnRefreshListener {

    @Inject
    HomeViewModelFactory viewModelFactory;

    @NotNull
    @Override
    protected HomeViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(HomeViewModel.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void observerViewModel() {
        mViewModel.videoListAdapter.getOnClickItemEvent().observe(this, youtubeData ->
                startActivity(
                        new Intent(requireContext().getApplicationContext(), PlayerActivity.class)
                                .putExtra(PlayerActivity.EXTRA_VIDEO, youtubeData)
                                .putExtra(PlayerActivity.EXTRA_VIDEO_LIST, (Serializable) mViewModel.videoList)
                )
        );

        mViewModel.videoListAdapter.getOnAddFavoritesEvent().observe(this, youtubeData -> {
            new FavoritesBottomSheetDialog(youtubeData).show(getParentFragmentManager());
        });

        mViewModel.videoListAdapter.getOnOpenYoutubeEvent().observe(this, this::openYoutube);

        mViewModel.videoListAdapter.getOnShareEvent().observe(this, this::share);

        mViewModel.videoListAdapter.getOnHideEvent().observe(this, youtubeData -> mViewModel.insertHiding(youtubeData));

        mViewModel.getOnSuccessHidingEvent().observe(this, o -> Toast.makeText(getContext(), R.string.message_hiding, Toast.LENGTH_SHORT).show());

        mViewModel.getOnErrorEvent().observe(this, o -> startActivity(new Intent(requireContext().getApplicationContext(), SplashActivity.class)));
    }

    private void openYoutube(YoutubeData youtubeData) {
        startActivity(
                new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://youtube.com/watch?v=" + youtubeData.getVideoId())
                )
        );
    }

    private void share(YoutubeData youtubeData) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "http://youtube.com/watch?v=" + youtubeData.getVideoId());
        startActivity(Intent.createChooser(intent, "싱생송 - 무료 노래방"));
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.setYoutubeDataList();
        mBinding.swipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mBinding.swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mBinding.swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mViewModel.setYoutubeDataList();
        mBinding.swipeRefreshLayout.setRefreshing(false);
    }
}
