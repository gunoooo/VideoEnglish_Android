package kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import kr.hs.dgsw.domain.model.Favorites;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseItemViewModel;

public class FavoritesItemViewModel extends BaseItemViewModel<FavoritesNavigator> {

    private Favorites favorites;

    private MutableLiveData<String> thumbnail = new MutableLiveData<>();
    public LiveData<String> getThumbnail() {
        return thumbnail;
    }
    private MutableLiveData<String> title = new MutableLiveData<>();
    public LiveData<String> getTitle() {
        return title;
    }
    private MutableLiveData<String> createDate = new MutableLiveData<>();
    public LiveData<String> getCreateDate() {
        return createDate;
    }
    private MutableLiveData<String> videoCount = new MutableLiveData<>();
    public LiveData<String> getVideoCount() {
        return videoCount;
    }

    void bind(Favorites data) {
        this.favorites = data;

        thumbnail.setValue(favorites.getFavoritesItemList() == null || favorites.getFavoritesItemList().isEmpty()
                ? null : favorites.getFavoritesItemList().get(0).getThumbnailUrl());
        title.setValue(favorites.getTitle());
        createDate.setValue(favorites.getCreateDate());
        videoCount.setValue("동영상 " + (favorites.getFavoritesItemList() == null ? 0 : favorites.getFavoritesItemList().size()) + "개");
    }

    public void onClickItem() {
        getNavigator().onClickItem(favorites);
    }

    public void onClickMenu(View view) {
        LinearLayout menuButton = (LinearLayout) view;
        PopupMenu popup = new PopupMenu(view.getContext(), menuButton);
        popup.inflate(R.menu.menu_favorites_item);
        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_play: {
                    getNavigator().onPlay(favorites);
                    return true;
                }
                case R.id.menu_fix_title: {
                    getNavigator().onFixTitle(favorites);
                    return true;
                }
                case R.id.menu_delete: {
                    getNavigator().onDelete(favorites);
                    return true;
                }
                default: return false;
            }
        });
        popup.show();
    }
}
