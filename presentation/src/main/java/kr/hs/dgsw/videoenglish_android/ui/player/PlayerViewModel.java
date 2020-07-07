package kr.hs.dgsw.videoenglish_android.ui.player;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableCompletableObserver;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.domain.usecase.recent.InsertRecentUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoListAdapter;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoViewType;

public class PlayerViewModel extends BaseViewModel {

    private InsertRecentUseCase insertRecentUseCase;

    public PlayerViewModel(InsertRecentUseCase insertRecentUseCase) {
        this.insertRecentUseCase = insertRecentUseCase;
    }

    YoutubeData video;

    private List<YoutubeData> videoList = new ArrayList<>();
    public VideoListAdapter videoListAdapter = new VideoListAdapter(videoList, VideoViewType.HORIZONTAL_NORMAL);

    private MutableLiveData<String> title = new MutableLiveData<>();
    public LiveData<String> getTitle() {
        return title;
    }

    void setVideo(YoutubeData video) {
        this.video = video;
        title.setValue(video.getVideoTitle());
    }

    void setVideoList(List<YoutubeData> videoList) {
        this.videoList.clear();
        this.videoList.addAll(videoList);
        videoListAdapter.notifyDataSetChanged();
    }

    void insertResent() {
        addDisposable(insertRecentUseCase.buildUseCaseObservable(new InsertRecentUseCase.Params(video)),
                new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() { }

                    @Override
                    public void onError(Throwable e) {
                        getOnErrorEvent().setValue(e);
                    }
                });
    }
}
