package com.demo.movieplus.ui.movies.placeholder;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    private String name;
    private String desc;
    private String title;
    private int image_url;
    private String url;
//    private WebView WebView;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public android.webkit.WebView getWebView() {
//        return WebView;
//    }
//
//    public void setWebView(android.webkit.WebView webView) {
//        WebView = webView;
//    }

    public PlaceholderContent(String name, String desc, String title, int image_url, String url) {
        this.name = name;
        this.desc = desc;
        this.title = title;
        this.image_url = image_url;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getYoutubeUrl() {

        return null;
    }

    public boolean toStringArray() {
        return false;
    }


    /**
     * An array of sample (placeholder) items.
     */
//    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();
//
//    /**
//     * A map of sample (placeholder) items, by ID.
//     */
//    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();
//
//    private static final int COUNT = 25;
//
//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createPlaceholderItem(i));
//        }
//    }
//
//    private static void addItem(PlaceholderItem item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.id, item);
//    }
//
//    private static PlaceholderItem createPlaceholderItem(int position) {
//        return new PlaceholderItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }
//
//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }
//
//    /**
//     * A placeholder item representing a piece of content.
//     */
//    public static class PlaceholderItem {
//        public final String id;
//        public final String content;
//        public final String details;
//
//        public PlaceholderItem(String id, String content, String details) {
//            this.id = id;
//            this.content = content;
//            this.details = details;
//        }
//
//        @Override
//        public String toString() {
//            return content;
//        }
//    }
}
