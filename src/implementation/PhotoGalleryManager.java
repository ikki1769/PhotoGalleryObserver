package implementation;

import interfaces.IPhotoGallery;
import interfaces.IViewer;
import models.Photo;
import java.util.ArrayList;
import java.util.List;

public class PhotoGalleryManager implements IPhotoGallery {
    private List<IViewer> viewers;
    private List<Photo> photos;
    private String galleryName;

    public PhotoGalleryManager(String galleryName) {
        this.galleryName = galleryName;
        this.viewers = new ArrayList<>();
        this.photos = new ArrayList<>();
    }

    @Override
    public void subscribe(IViewer viewer) {
        viewers.add(viewer);
        System.out.println(viewer.getUsername() + " subscribed to " + galleryName + " updates");
    }

    @Override
    public void unsubscribe(IViewer viewer) {
        viewers.remove(viewer);
        System.out.println(viewer.getUsername() + " unsubscribed from " + galleryName);
    }

    @Override
    public void notifyViewers(String update) {
        System.out.println("\n[" + galleryName + "] Notifying all viewers...");
        for (IViewer viewer : viewers) {
            viewer.update(update);
        }
    }

    public void uploadPhoto(String id, String title, String category) {
        Photo photo = new Photo(id, title, category);
        photos.add(photo);
        System.out.println("\nNew photo uploaded: " + title + " [" + category + "]");
        notifyViewers("New photo added: " + title + " in category: " + category);
    }

    public void deletePhoto(String photoId) {
        Photo toRemove = null;
        for (Photo photo : photos) {
            if (photo.getId().equals(photoId)) {
                toRemove = photo;
                break;
            }
        }

        if (toRemove != null) {
            photos.remove(toRemove);
            System.out.println("\nPhoto deleted: " + toRemove.getTitle());
            notifyViewers("Photo removed: " + toRemove.getTitle());
        }
    }

    public void editPhoto(String photoId, String newTitle) {
        for (Photo photo : photos) {
            if (photo.getId().equals(photoId)) {
                String oldTitle = photo.getTitle();
                photo.setTitle(newTitle);
                System.out.println("\nPhoto edited: " + oldTitle + " -> " + newTitle);
                notifyViewers("Photo updated: " + oldTitle + " renamed to " + newTitle);
                return;
            }
        }
    }

    public int getPhotoCount() {
        return photos.size();
    }
}