package kr.hs.dgsw.videoenglish_android.ui.splash;

import androidx.lifecycle.LiveData;

import io.reactivex.observers.DisposableCompletableObserver;
import kr.hs.dgsw.domain.usecase.playlist.InsertDefaultPlaylistUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;

public class SplashViewModel extends BaseViewModel {

    private InsertDefaultPlaylistUseCase insertDefaultPlaylistUseCase;

    public SplashViewModel(InsertDefaultPlaylistUseCase insertDefaultPlaylistUseCase) {
        this.insertDefaultPlaylistUseCase = insertDefaultPlaylistUseCase;
        insertDefaultPlaylist();
    }

    private SingleLiveEvent onSuccessEvent = new SingleLiveEvent();
    public LiveData getOnSuccessEvent() {
        return onSuccessEvent;
    }

    private void insertDefaultPlaylist() {
        addDisposable(insertDefaultPlaylistUseCase.buildUseCaseObservable(),
                new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        onSuccessEvent.call();
                    }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
    }
}
