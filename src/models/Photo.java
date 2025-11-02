package models;

public class Photo {
    private String id;
    private String title;
    private String category;

    public Photo(String id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}