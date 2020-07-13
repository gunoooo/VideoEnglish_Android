package kr.hs.dgsw.data.network.response;

import javax.annotation.Nullable;
import java.util.Date;

import kr.hs.dgsw.data.network.response.ResourceId;
import kr.hs.dgsw.data.network.response.ThumbnailDetails;

public class PlaylistItemSnippet {
    private final String channelId;
    private final String channelTitle;
    private final String description;
    private final Date publishedAt;
    private final String playlistId;
    private final ResourceId resourceId;
    @Nullable
    private final ThumbnailDetails thumbnails;
    private final String title;

    public PlaylistItemSnippet(String channelId,
                               String channelTitle,
                               String description,
                               Date publishedAt,
                               String playlistId,
                               ResourceId resourceId,
                               @Nullable ThumbnailDetails thumbnails,
                               String title) {
        this.channelId = channelId;
        this.channelTitle = channelTitle;
        this.description = description;
        this.publishedAt = publishedAt;
        this.playlistId = playlistId;
        this.resourceId = resourceId;
        this.thumbnails = thumbnails;
        this.title = title;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public ResourceId getResourceId() {
        return resourceId;
    }

    @Nullable
    public ThumbnailDetails getThumbnails() {
        return thumbnails;
    }

    public String getTitle() {
        return title;
    }
}
