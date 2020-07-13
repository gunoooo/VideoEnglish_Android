package kr.hs.dgsw.data.network.response;

import javax.annotation.Nullable;

public class Thumbnail {
    private final long height;
    @Nullable
    private final String url;
    private final long width;

    public Thumbnail(long height,
                     @Nullable String url,
                     long width) {
        this.height = height;
        this.url = url;
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public long getWidth() {
        return width;
    }
}
