package kr.hs.dgsw.videoenglish_android.widget.recyclerview.recent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseItemViewModel;

public class RecentItemViewModel extends BaseItemViewModel<RecentNavigator> {

    private YoutubeData youtubeData;

    private MutableLiveData<String> thumbnail = new MutableLiveData<>();
    public LiveData<String> getThumbnail() {
        return thumbnail;
    }
    private MutableLiveData<String> title = new MutableLiveData<>();
    public LiveData<String> getTitle() {
        return title;
    }

    void bind(YoutubeData data) {
        this.youtubeData = data;

        thumbnail.setValue(youtubeData.getThumbnailUrl());
        title.setValue(youtubeData.getVideoTitle());
    }

    public void onClickItem() {
        getNavigator().onClickItem(youtubeData);
    }
}
