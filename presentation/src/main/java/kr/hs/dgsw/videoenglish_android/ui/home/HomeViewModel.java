package kr.hs.dgsw.videoenglish_android.ui.home;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import kr.hs.dgsw.data.util.Constants;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.domain.usecase.playlist.GetPlaylistListUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoListAdapter;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.video.VideoViewType;

public class HomeViewModel extends BaseViewModel {

    private GetPlaylistListUseCase getPlaylistListUseCase;

    public HomeViewModel(GetPlaylistListUseCase getPlaylistListUseCase) {
        this.getPlaylistListUseCase = getPlaylistListUseCase;
        setYoutubeDataList();
    }

    List<YoutubeData> videoList = new ArrayList<>();
    public VideoListAdapter videoListAdapter = new VideoListAdapter(videoList, VideoViewType.VERTICAL_NORMAL);

    private void setYoutubeDataList() {
        addDisposable(getPlaylistListUseCase.buildUseCaseObservable(new GetPlaylistListUseCase.Params(Constants.HOME_PLAYLIST_ID)),
                new DisposableSingleObserver<List<YoutubeData>>() {
                    @Override
                    public void onSuccess(List<YoutubeData> youtubeDataList) {
                        HomeViewModel.this.videoList.clear();
                        HomeViewModel.this.videoList.addAll(youtubeDataList);
                        videoListAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
    }
}
