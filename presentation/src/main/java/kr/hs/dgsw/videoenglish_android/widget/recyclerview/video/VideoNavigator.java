package kr.hs.dgsw.videoenglish_android.widget.recyclerview.video;

import kr.hs.dgsw.domain.model.YoutubeData;

interface VideoNavigator {
    void onClickItem(YoutubeData youtubeData);
    void addFavorites(YoutubeData youtubeData);
    void deleteFavorites(YoutubeData youtubeData);
    void hide(YoutubeData youtubeData);
    void deleteHiding(YoutubeData youtubeData);
    void openYoutube(YoutubeData youtubeData);
    void share(YoutubeData youtubeData);
}
