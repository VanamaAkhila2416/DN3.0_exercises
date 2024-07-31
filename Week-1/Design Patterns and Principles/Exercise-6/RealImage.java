public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading " + filename + " from remote server...");
        try {
            Thread.sleep(2000); // Simulate time delay for loading image
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(filename + " loaded from remote server.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
