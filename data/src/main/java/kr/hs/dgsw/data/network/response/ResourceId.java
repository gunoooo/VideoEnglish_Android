package kr.hs.dgsw.data.network.response;

public class ResourceId {
    private final String kind;
    private final String videoId;

    public ResourceId(String kind,
                      String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public String getVideoId() {
        return videoId;
    }
}
