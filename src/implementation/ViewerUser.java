package implementation;

import interfaces.IViewer;

public class ViewerUser implements IViewer {
    private String username;
    private String favoriteCategory;

    public ViewerUser(String username, String favoriteCategory) {
        this.username = username;
        this.favoriteCategory = favoriteCategory;
    }

    public ViewerUser() {
        this.username = "Anonymous";
        this.favoriteCategory = "All";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFavoriteCategory(String favoriteCategory) {
        this.favoriteCategory = favoriteCategory;
    }

    @Override
    public void update(String photoUpdate) {
        if (photoUpdate.contains(favoriteCategory)) {
            System.out.println("★ [" + username + "] FAVORITE: " + photoUpdate);
        } else {
            System.out.println("  [" + username + "] notification: " + photoUpdate);
        }
    }

    @Override
    public String getUsername() {
        return username;
    }
}