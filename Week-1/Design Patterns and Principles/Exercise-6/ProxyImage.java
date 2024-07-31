import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private String filename;
    private static Map<String, RealImage> imageCache = new HashMap<>();

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (!imageCache.containsKey(filename)) {
            RealImage realImage = new RealImage(filename);
            imageCache.put(filename, realImage);
        } else {
            System.out.println("Loading " + filename + " from cache...");
        }
        imageCache.get(filename).display();
    }
}
