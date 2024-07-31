public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded from remote server and displayed
        image1.display();
        System.out.println();

        // Image will be displayed without loading from remote server
        image1.display();
        System.out.println();

        // Image will be loaded from remote server and displayed
        image2.display();
        System.out.println();

        // Image will be displayed without loading from remote server
        image2.display();
        System.out.println();

        // Displaying image that is already cached
        Image image3 = new ProxyImage("image1.jpg");
        image3.display();
    }
}
