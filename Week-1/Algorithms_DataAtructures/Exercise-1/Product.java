package InventoryManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Product {
    int pId;
    String pName;
    double qty;
    double price;

    public Product(int pId, String pName, double qty, double price) {
        this.pId = pId;
        this.pName = pName;
        this.qty = qty;
        this.price = price;
    }

    static HashMap<Integer, Product> store = new HashMap<>();

    public static void addProduct(int pId, String pName, double qty, double price) {
        if (!store.containsKey(pId)) {
            store.put(pId, new Product(pId, pName, qty, price));
            System.out.println("The product with ID " + pId + " has been added.");
        } else {
            System.out.println("The product with ID " + pId + " already exists.");
            System.out.println("Do you want to update the quantity of the item? [Y/N]");
            Scanner sc = new Scanner(System.in);
            String response = sc.next();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Enter the quantity to add:");
                double addQuantity = sc.nextDouble();
                updateQuantity(pId, addQuantity);
            }
        }
        displayInventory();
    }

    public static void deleteProduct(int pId) {
        if (store.containsKey(pId)) {
            store.remove(pId);
            System.out.println("The product with ID " + pId + " has been deleted.");
        } else {
            System.out.println("Product with ID " + pId + " not found.");
        }
        displayInventory();
    }

    public static void updateQuantity(int pId, double qtyChange) {
        if (store.containsKey(pId)) {
            Product product = store.get(pId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to update the quantity of the item? [1: increase  2: decrease]");
            int response = sc.nextInt();
            if (response == 1) {
                product.quantity += qtyChange;
            } else if (response == 2) {
                product.quantity -= qtyChange;
            } else {
                System.out.println("Please enter either 1 or 2.");
            }
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Product with ID " + pId + " not found.");
        }
        displayInventory();
    }

    public static void updatePrice(int pId, double priceChange) {
        if (store.containsKey(pId)) {
            Product product = store.get(pId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to update the price of the item? [1: increase  2: decrease]");
            int response = sc.nextInt();
            if (response == 1) {
                product.price += priceChange;
            } else if (response == 2) {
                product.price -= priceChange;
            } else {
                System.out.println("Please enter either 1 or 2.");
            }
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Product with ID " + pId + " not found.");
        }
        displayInventory();
    }

    public static void updateProductName(int pId, String newProductName) {
        if (store.containsKey(pId)) {
            Product product = store.get(pId);
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to update the name of the item? [Y/N]");
            String response = sc.next();
            if (response.equalsIgnoreCase("Y")) {
                product.productName = newProductName;
                System.out.println("Updated product: " + product);
            }
        } else {
            System.out.println("Product with ID " + pId + " not found.");
        }
        displayInventory();
    }

    public static void displayInventory() {
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n", "Product ID", "Product Name", "Quantity", "Price");
        System.out.println("------------------------------------------------------");
        for (Product product : store.values()) {
            System.out.printf("| %-10d | %-20s | %-10.2f | %-10.2f |\n", product.pId, product.pName, product.qty, product.price);
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + pId +
                ", productName='" + pName + '\'' +
                ", quantity=" + qty +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----- Inventory Management System -----");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Quantity of the Product");
            System.out.println("4. Update Price of the Product");
            System.out.println("5. Update Name of the Product");
            System.out.println("6. Display Inventory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int pId = sc.nextInt();
                    System.out.print("Enter Product Name: ");
                    String pName = sc.next();
                    System.out.print("Enter Product Quantity: ");
                    double qty = sc.nextDouble();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    addProduct(pId, pName, qty, price);
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int deleteId = sc.nextInt();
                    deleteProduct(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    int updateQuantityId = sc.nextInt();
                    System.out.print("Enter Quantity Change: ");
                    double quantityChange = sc.nextDouble();
                    updateQuantity(updateQuantityId, quantityChange);
                    break;
                case 4:
                    System.out.print("Enter Product ID: ");
                    int priceUpdateId = sc.nextInt();
                    System.out.print("Enter Price Change: ");
                    double priceChange = sc.nextDouble();
                    updatePrice(priceUpdateId, priceChange);
                    break;
                case 5:
                    System.out.print("Enter Product ID: ");
                    int nameUpdateId = sc.nextInt();
                    System.out.print("Enter New Product Name: ");
                    String newProductName = sc.next();
                    updateProductName(nameUpdateId, newProductName);
                    break;
                case 6:
                    displayInventory();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
