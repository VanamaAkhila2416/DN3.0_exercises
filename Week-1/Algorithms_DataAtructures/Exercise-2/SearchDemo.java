import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Tablet", "Electronics"));
        products.add(new Product(2, "Shoes", "Apparel"));
        products.add(new Product(3, "Watch", "Accessories"));
        products.add(new Product(4, "mobile", "Electronics"));
        products.add(new Product(5, "Backpack", "Accessories"));

        // Linear search
        LinearSearch l = new LinearSearch();
        Product rLinear = linearSearch.linearSearch(products, "Backpack");
        System.out.println("Linear Search Result: " + rLinear);

        // Sort products by name for binary search
        Collections.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        // Binary search
        BinarySearch b = new BinarySearch();
        Product rBinary = binarySearch.binarySearch(products, "Backpack");
        System.out.println("Binary Search Result: " + rBinary);
    }
}
