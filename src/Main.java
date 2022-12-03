import objects.Product;
import utilities.ProductArray;

public class Main {
    public static void main(String[] args) {
        Product[] catalogue = ProductArray.generateProducts(20);
        ProductArray.printProducts(catalogue);
        ProductArray.sortProductsbyPrice(catalogue);
        System.out.println("SORT BY PRICE");
        ProductArray.printProducts(catalogue);
        ProductArray.sortProductsbyName(catalogue);
        System.out.println("SORT BY NAME");
        ProductArray.printProducts(catalogue);
        ProductArray.sortProductsbyManufacturer(catalogue);
        System.out.println("SORT BY MANUFACTURER");
        ProductArray.printProducts(catalogue);
        ProductArray.printAnalytic(catalogue);
        System.out.println("DELETE PRODUCT ID 2");
        catalogue = ProductArray.deleteProduct(catalogue,(short) 2);
        ProductArray.printProducts(catalogue);
    }
}