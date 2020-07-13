package kr.hs.dgsw.data.network.response;


public class PlaylistItem {
    private final String etag;
    private final String kind;
    private final PlaylistItemSnippet snippet;

    public PlaylistItem(String etag,
                        String kind,
                        PlaylistItemSnippet snippet) {
        this.etag = etag;
        this.kind = kind;
        this.snippet = snippet;
    }

    public String getEtag() {
        return etag;
    }

    public String getKind() {
        return kind;
    }

    public PlaylistItemSnippet getSnippet() {
        return snippet;
    }
}
