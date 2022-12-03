import objects.Product;
import utilities.ProductArray;

public class Main {
    public static void main(String[] args) {
        Product[] catalouge = ProductArray.generateProducts(20);
        ProductArray.printProducts(catalouge);
        ProductArray.sortProductsbyPrice(catalouge);
        System.out.println("SORT BY PRICE");
        ProductArray.printProducts(catalouge);

        ProductArray.sortProductsbyName(catalouge);
        System.out.println("SORT BY NAME");
        ProductArray.printProducts(catalouge);

        ProductArray.sortProductsbyManufacturer(catalouge);
        System.out.println("SORT BY MANUFACTURER");
        ProductArray.printProducts(catalouge);
        ProductArray.printAnalytic(catalouge);
        //ProductArray.updateProduct(catalouge,(short) 90,null,null,Double.NaN,"Phát Tài","Chi tiết thiết kế");
        //ProductArray.printProduct(catalouge, (short) 2);
        System.out.println("DELETE PRODUCT ID 2");
        catalouge = ProductArray.deleteProduct(catalouge,(short) 2);
        ProductArray.printProducts(catalouge);
    }
}