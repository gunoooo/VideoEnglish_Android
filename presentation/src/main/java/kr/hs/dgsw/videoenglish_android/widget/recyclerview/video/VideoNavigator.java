package kr.hs.dgsw.videoenglish_android.widget.recyclerview.video;

import kr.hs.dgsw.domain.model.YoutubeData;

interface VideoNavigator {
    void onClickItem(YoutubeData youtubeData);
    void onAddFavorites(YoutubeData youtubeData);
    void onDeleteFavorites(YoutubeData youtubeData);
    void onHide(YoutubeData youtubeData);
    void onDeleteHiding(YoutubeData youtubeData);
    void onOpenYoutube(YoutubeData youtubeData);
    void onShare(YoutubeData youtubeData);
}
