package kr.hs.dgsw.videoenglish_android.ui.list;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;

import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.base.BaseActivity;
import kr.hs.dgsw.videoenglish_android.databinding.ActivityListBinding;
import kr.hs.dgsw.videoenglish_android.ui.favorites.FavoritesBottomSheetDialog;
import kr.hs.dgsw.videoenglish_android.ui.player.PlayerActivity;

public class ListActivity extends BaseActivity<ActivityListBinding, ListViewModel> {

    @Inject
    ListViewModelFactory viewModelFactory;

    public static final String EXTRA_TITLE = "TITLE";
    public static final String EXTRA_VIDEO_LIST = "videoList";

    @NotNull
    @Override
    protected ListViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(ListViewModel.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void observerViewModel() {
        mViewModel.videoListAdapter.getOnClickItemEvent().observe(this, youtubeData ->
                startActivity(
                        new Intent(getApplicationContext(), PlayerActivity.class)
                                .putExtra(PlayerActivity.EXTRA_VIDEO, youtubeData)
                                .putExtra(PlayerActivity.EXTRA_VIDEO_LIST, (Serializable) mViewModel.getVideoList())
                )
        );

        mViewModel.videoListAdapter.getOnAddFavoritesEvent().observe(this, youtubeData -> {
            new FavoritesBottomSheetDialog(youtubeData).show(getSupportFragmentManager());
        });

        mViewModel.videoListAdapter.getOnOpenYoutubeEvent().observe(this, this::openYoutube);

        mViewModel.videoListAdapter.getOnShareEvent().observe(this, this::share);

        mViewModel.videoListAdapter.getOnHideEvent().observe(this, youtubeData -> mViewModel.insertHiding(youtubeData));

        mViewModel.getOnSuccessHidingEvent().observe(this, o -> Toast.makeText(this, R.string.message_hiding, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntent();
        setSupportActionBar(mBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void initIntent() {
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        if (title == null) {
            finish();
            return;
        }
        mBinding.toolbar.setTitle(title);
        Serializable videoList = getIntent().getSerializableExtra(EXTRA_VIDEO_LIST);
        if (videoList == null) {
            finish();
            return;
        }
        mViewModel.setVideoList((ArrayList<YoutubeData>) videoList);
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
}
