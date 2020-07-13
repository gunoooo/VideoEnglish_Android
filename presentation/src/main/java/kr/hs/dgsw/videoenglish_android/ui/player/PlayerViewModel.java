package kr.hs.dgsw.videoenglish_android.ui.player;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableCompletableObserver;
import kr.hs.dgsw.domain.model.Word;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.domain.usecase.hiding.InsertHidingUseCase;
import kr.hs.dgsw.domain.usecase.recent.InsertRecentUseCase;
import kr.hs.dgsw.domain.usecase.word.InsertWordUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoListAdapter;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoViewType;

public class PlayerViewModel extends BaseViewModel {

    private InsertRecentUseCase insertRecentUseCase;
    private InsertWordUseCase insertWordUseCase;
    private InsertHidingUseCase insertHidingUseCase;

    public PlayerViewModel(InsertRecentUseCase insertRecentUseCase,
                           InsertWordUseCase insertWordUseCase,
                           InsertHidingUseCase insertHidingUseCase) {
        this.insertRecentUseCase = insertRecentUseCase;
        this.insertWordUseCase = insertWordUseCase;
        this.insertHidingUseCase = insertHidingUseCase;
    }

    YoutubeData video;

    private List<YoutubeData> videoList = new ArrayList<>();
    public VideoListAdapter videoListAdapter = new VideoListAdapter(videoList, VideoViewType.HORIZONTAL_NORMAL);

    public MutableLiveData<String> english = new MutableLiveData<>();
    public MutableLiveData<String> korean = new MutableLiveData<>();

    private MutableLiveData<String> title = new MutableLiveData<>();
    public LiveData<String> getTitle() {
        return title;
    }

    private SingleLiveEvent onEmptyWordEvent = new SingleLiveEvent();
    public LiveData getOnEmptyWordEvent() {
        return onEmptyWordEvent;
    }
    private SingleLiveEvent onSuccessHidingEvent = new SingleLiveEvent<>();
    LiveData getOnSuccessHidingEvent() {
        return onSuccessHidingEvent;
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

    List<YoutubeData> getVideoList() {
        return videoList;
    }

    void insertResent() {
        addDisposable(insertRecentUseCase.buildUseCaseObservable(new InsertRecentUseCase.Params(video)),
                new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() { }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
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

    public void onClickAddWord() {
        boolean isEmptyEnglish = english.getValue() == null || english.getValue().isEmpty();
        boolean isEmptyKorean = korean.getValue() == null || korean.getValue().isEmpty();
        if (isEmptyEnglish || isEmptyKorean) {
            onEmptyWordEvent.call();
            return;
        }
        addDisposable(insertWordUseCase.buildUseCaseObservable(new InsertWordUseCase.Params(new Word(english.getValue(), korean.getValue()))),
                new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        english.setValue("");
                        korean.setValue("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
    }
}
