package kr.hs.dgsw.videoenglish_android.widget.recyclerview.video;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseItemViewModel;

public class VideoItemViewModel extends BaseItemViewModel<VideoNavigator> {

    private YoutubeData youtubeData;
    private VideoViewType videoViewType;

    private MutableLiveData<String> thumbnail = new MutableLiveData<>();
    public LiveData<String> getThumbnail() {
        return thumbnail;
    }
    private MutableLiveData<String> title = new MutableLiveData<>();
    public LiveData<String> getTitle() {
        return title;
    }
    private MutableLiveData<String> channel = new MutableLiveData<>();
    public LiveData<String> getChannel() {
        return channel;
    }

    void bind(YoutubeData data, VideoViewType videoViewType) {
        this.youtubeData = data;
        this.videoViewType = videoViewType;

        thumbnail.setValue(youtubeData.getThumbnailUrl());
        title.setValue(youtubeData.getVideoTitle());
        channel.setValue(youtubeData.getChannelTitle());
    }

    public void onClickItem() {
        getNavigator().onClickItem(youtubeData);
    }

    public void onClickMenu(View view) {
        LinearLayout menuButton = (LinearLayout) view;
        PopupMenu popup = new PopupMenu(view.getContext(), menuButton);
        if (youtubeData.isHiding())
            popup.inflate(R.menu.menu_hiding_video_item);
        else if (videoViewType == VideoViewType.HORIZONTAL_FAVORITES ||
                    videoViewType == VideoViewType.VERTICAL_FAVORITES)
            popup.inflate(R.menu.menu_favorites_video_item);
        else
            popup.inflate(R.menu.menu_video_item);
        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_add_favorites: {
                    getNavigator().addFavorites(youtubeData);
                    return true;
                }
                case R.id.menu_delete_favorites: {
                    getNavigator().deleteFavorites(youtubeData);
                    return true;
                }
                case R.id.menu_hide: {
                    getNavigator().hide(youtubeData);
                    return true;
                }
                case R.id.menu_delete_hiding: {
                    getNavigator().deleteHiding(youtubeData);
                    return true;
                }
                case R.id.menu_open_youtube: {
                    getNavigator().openYoutube(youtubeData);
                    return true;
                }
                case R.id.menu_share: {
                    getNavigator().share(youtubeData);
                    return true;
                }
                default: return false;
            }
        });
        popup.show();
    }
}
