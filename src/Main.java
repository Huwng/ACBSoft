import objects.Category;
import objects.Product;
import objects.WoodType;
import utilities.ProductArray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> catalogue = ProductArray.generateProducts(20);
        ProductArray.printProducts(catalogue);
        System.out.println();
        //ProductArray.updateFurnitureProduct(catalogue,(short) 2,"f",Double.NaN,"a du","du a",69, WoodType.BIRCH);
        //ProductArray.printProducts(catalogue);
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
        ProductArray.deleteProduct(catalogue,(short) 2);
        ProductArray.printProducts(catalogue);

    }
}