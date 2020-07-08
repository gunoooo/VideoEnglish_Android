package kr.hs.dgsw.videoenglish_android.ui.player;

import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;

import kr.co.prnd.YouTubePlayerView;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.base.BaseActivity;
import kr.hs.dgsw.videoenglish_android.databinding.ActivityPlayerBinding;

public class PlayerActivity extends BaseActivity<ActivityPlayerBinding, PlayerViewModel> {

    @Inject
    PlayerViewModelFactory viewModelFactory;

    public static final String EXTRA_VIDEO = "video";
    public static final String EXTRA_VIDEO_LIST = "videoList";

    @NotNull
    @Override
    protected PlayerViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(PlayerViewModel.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void observerViewModel() {
        mViewModel.getOnEmptyWordEvent().observe(this, o ->
                Toast.makeText(this, R.string.error_empty, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntent();
    }

    @SuppressWarnings("unchecked")
    private void initIntent() {
        Serializable video = getIntent().getSerializableExtra(EXTRA_VIDEO);
        if (video == null) {
            finish();
            return;
        }
        mViewModel.setVideo((YoutubeData) video);
        initVideo();
        mViewModel.insertResent();
        Serializable videoList = getIntent().getSerializableExtra(EXTRA_VIDEO_LIST);
        if (videoList == null) {
            finish();
            return;
        }
        mViewModel.setVideoList((ArrayList<YoutubeData>) videoList);
    }

    private void initVideo() {
        mBinding.youtubePlayerView.play(Objects.requireNonNull(mViewModel.video.getVideoId()), new YouTubePlayerView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(@NotNull YouTubePlayer.Provider provider, @NotNull YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(mViewModel.video.getVideoId());
            }

            @Override
            public void onInitializationFailure(@NotNull YouTubePlayer.Provider provider, @NotNull YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
