import implementation.PhotoGalleryManager;
import implementation.ViewerUser;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Photo Gallery Observer Pattern Demo ===\n");

        // Create gallery
        PhotoGalleryManager gallery = new PhotoGalleryManager("Nature Gallery");

        // Create viewers with favorite categories
        ViewerUser viewer1 = new ViewerUser("Ismail", "Nature");
        ViewerUser viewer2 = new ViewerUser("Saniya", "Wildlife");
        ViewerUser viewer3 = new ViewerUser("Erkezhan", "Landscape");

        // Subscribe viewers
        System.out.println("--- Subscribing Viewers ---");
        gallery.subscribe(viewer1);
        gallery.subscribe(viewer2);
        gallery.subscribe(viewer3);

        // Upload photos
        gallery.uploadPhoto("001", "Mountain Sunrise", "Nature");
        gallery.uploadPhoto("002", "Tiger in Forest", "Wildlife");

        // Edit photo
        gallery.editPhoto("001", "Golden Mountain Sunrise");

        // Unsubscribe one viewer
        System.out.println("\n--- Unsubscribing Viewer ---");
        gallery.unsubscribe(viewer3);

        // Upload another photo
        gallery.uploadPhoto("003", "Ocean Waves", "Landscape");

        // Delete photo
        gallery.deletePhoto("002");

        System.out.println("\n--- Gallery Stats ---");
        System.out.println("Total photos: " + gallery.getPhotoCount());
    }
}