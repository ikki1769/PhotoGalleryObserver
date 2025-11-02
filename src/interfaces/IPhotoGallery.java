package interfaces;

public interface IPhotoGallery {
    void subscribe(IViewer viewer);
    void unsubscribe(IViewer viewer);
    void notifyViewers(String update);
}
