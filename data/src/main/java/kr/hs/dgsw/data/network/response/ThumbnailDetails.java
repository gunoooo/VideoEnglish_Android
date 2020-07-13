package kr.hs.dgsw.data.network.response;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

public class ThumbnailDetails {
    @Nullable
    @SerializedName("default")
    private Thumbnail _default;
    @Nullable
    private Thumbnail high;
    @Nullable
    private Thumbnail medium;

    @Nullable
    public String getThumbnailUrl() {
        return high != null ? high.getUrl() : medium != null ? medium.getUrl() : _default != null ? _default.getUrl() : null;
    }

    @Nullable
    public Thumbnail getDefault() {
        return _default;
    }

    @Nullable
    public Thumbnail getHigh() {
        return high;
    }

    @Nullable
    public Thumbnail getMedium() {
        return medium;
    }
}
