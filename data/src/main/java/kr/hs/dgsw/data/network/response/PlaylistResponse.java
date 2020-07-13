package kr.hs.dgsw.data.network.response;

import java.util.List;

public class PlaylistResponse {
    private final List<PlaylistItem> items;

    public PlaylistResponse(List<PlaylistItem> items) {
        this.items = items;
    }

    public List<PlaylistItem> getItems() {
        return items;
    }
}
