package kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites;

import kr.hs.dgsw.domain.model.Favorites;

public interface FavoritesNavigator {
    void onClickItem(Favorites favorites);
    void onPlay(Favorites favorites);
    void onFixTitle(Favorites favorites);
    void onDelete(Favorites favorites);
}
