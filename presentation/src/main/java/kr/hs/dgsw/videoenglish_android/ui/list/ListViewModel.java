package kr.hs.dgsw.videoenglish_android.ui.list;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableCompletableObserver;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.domain.usecase.hiding.InsertHidingUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoListAdapter;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoViewType;

public class ListViewModel extends BaseViewModel {

    private InsertHidingUseCase insertHidingUseCase;

    public ListViewModel(InsertHidingUseCase insertHidingUseCase) {
        this.insertHidingUseCase = insertHidingUseCase;
    }

    private List<YoutubeData> videoList = new ArrayList<>();
    public VideoListAdapter videoListAdapter = new VideoListAdapter(videoList, VideoViewType.HORIZONTAL_FAVORITES);

    private SingleLiveEvent onSuccessHidingEvent = new SingleLiveEvent<>();
    LiveData getOnSuccessHidingEvent() {
        return onSuccessHidingEvent;
    }

    void setVideoList(List<YoutubeData> videoList) {
        this.videoList.clear();
        this.videoList.addAll(videoList);
        videoListAdapter.notifyDataSetChanged();
    }

    List<YoutubeData> getVideoList() {
        return videoList;
    }

    void insertHiding(YoutubeData video) {
        addDisposable(insertHidingUseCase.buildUseCaseObservable(new InsertHidingUseCase.Params(video)),
                new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        int position = videoList.indexOf(video);
                        videoList.remove(video);
                        videoListAdapter.notifyItemRemoved(position);
                        onSuccessHidingEvent.call();
                    }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
    }
}
