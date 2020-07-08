package kr.hs.dgsw.videoenglish_android.ui.locker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gunwoo.karaoke.data.exception.ListEmptyException;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import kr.hs.dgsw.domain.model.Favorites;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.domain.usecase.favorites.GetFavoritesListUseCase;
import kr.hs.dgsw.domain.usecase.recent.GetRecentListUseCase;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites.FavoritesListAdapter;
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.recent.RecentListAdapter;

public class LockerViewModel extends BaseViewModel {

    private GetRecentListUseCase getRecentListUseCase;
    private GetFavoritesListUseCase getFavoritesListUseCase;

    public LockerViewModel(GetRecentListUseCase getRecentListUseCase,
                    GetFavoritesListUseCase getFavoritesListUseCase) {
        this.getRecentListUseCase = getRecentListUseCase;
        this.getFavoritesListUseCase = getFavoritesListUseCase;
    }

    List<YoutubeData> recentList = new ArrayList<>();
    public RecentListAdapter recentListAdapter = new RecentListAdapter(recentList);
    List<Favorites> favoritesList = new ArrayList<>();
    public FavoritesListAdapter favoritesListAdapter = new FavoritesListAdapter(favoritesList);

    private MutableLiveData<Boolean> isEmptyRecentList = new MutableLiveData<>();
    public LiveData<Boolean> getIsEmptyRecentList() {
        return isEmptyRecentList;
    }

    private SingleLiveEvent onClickRecentListEvent = new SingleLiveEvent();
    LiveData getOnClickRecentListEvent() {
        return onClickRecentListEvent;
    }
    private SingleLiveEvent onOpenFavoritesAddViewEvent = new SingleLiveEvent();
    LiveData getOnOpenFavoritesAddViewEvent() {
        return onOpenFavoritesAddViewEvent;
    }

    void setRecentList() {
        addDisposable(getRecentListUseCase.buildUseCaseObservable(),
                new DisposableSingleObserver<List<YoutubeData>>() {
                    @Override
                    public void onSuccess(List<YoutubeData> youtubeDataList) {
                        LockerViewModel.this.recentList.clear();
                        LockerViewModel.this.recentList.addAll(youtubeDataList);
                        recentListAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof ListEmptyException)
                            isEmptyRecentList.setValue(true);
                        else
                            setOnErrorEvent(e);
                    }
                });
    }

    void setFavoritesList() {
        addDisposable(getFavoritesListUseCase.buildUseCaseObservable(new GetFavoritesListUseCase.Params()),
                new DisposableSingleObserver<List<Favorites>>() {
                    @Override
                    public void onSuccess(List<Favorites> favoritesList) {
                        LockerViewModel.this.favoritesList.clear();
                        LockerViewModel.this.favoritesList.addAll(favoritesList);
                        favoritesListAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        setOnErrorEvent(e);
                    }
                });
    }

    public void onClickRecentList() {
        onClickRecentListEvent.call();
    }

    public void onClickAddFavorites() {
        onOpenFavoritesAddViewEvent.call();
    }
}
