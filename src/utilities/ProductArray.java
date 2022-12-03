package utilities;

import objects.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ProductArray {
    /**
     * Generate an array of predefined {@code "n"} products
     * @param n the number of products need to be generated
     * @return a java.Arrays of Product objects ({@code Product[]})
     */
    public static Product[] generateProducts(int n){
        //initiate our "catalogue"
        Product[] catalogue = new Product[n];
        //array of names for products
        String[] WOODFURNITURE_product_Name = {
                "Bàn phòng khách", "Bàn ăn", "Ghế bành", "Giường", "Sập", "Tủ quần áo"
        };
        String[] TILES_product_Name = {
                "Gạch men", "Gạch ốp tường", "Gạch hoa", "Gạch đá hoa cương", "Gạch bông", "Ngói"
        };
        //array of manufacturers
        String[] product_manufacturer = {
                "Hoa Sen", "Hoà Phát", "Nhân Hoà", "Xuân Hoà", "Mikado"
        };

        //initiate first index
        short index = 1;
        //get the size of Category enum to randomize later
        final int CategorySize = Category.values().length;
        //initiate random engine
        final Random random = new Random();
        //for-index loop through the product catalogue to set the properties of each product
        for (int i = 0, catalogueLength = catalogue.length; i < catalogueLength; i++) {
            catalogue[i] = new Product();
            catalogue[i].setProduct_ID(index);
            catalogue[i].setProduct_Category(Category.values()[random.nextInt(CategorySize - 1) + 1 /*randomize between 1 and CategorySize-1 (in this case, 2)*/]);
            //if the product is a wood furniture, use the name in WOODFURNITURE_product_Name as the product name, else if the product is a tile, use the name in TILES_product_Name instead
            if (catalogue[i].getProduct_Category() == Category.WOODFURNITURE) {
                catalogue[i].setProduct_Name(WOODFURNITURE_product_Name[random.nextInt(WOODFURNITURE_product_Name.length)]);
            } else if (catalogue[i].getProduct_Category() == Category.TILES) {
                catalogue[i].setProduct_Name(TILES_product_Name[random.nextInt(TILES_product_Name.length)]);
            }
            catalogue[i].setProduct_Price(random.nextDouble()*100);
            catalogue[i].setProduct_Manufacturer(product_manufacturer[random.nextInt(product_manufacturer.length)]);
            index++;
        }
        return catalogue;
    }

    /**
     * Prints out a {@code Product[]} array to {@code System.out}
     * @param catalouge {@code Product[]} array
     */
    public static void printProducts(Product[] catalouge){
        for (Product product:catalouge) {
            System.out.println(product);
        }
    }

    /**
     * Prints out a {@code Product} in a {@code Product[]} array given its {@code Product_ID}
     * @param catalouge {@code Product[]} array
     * @param ID {@code Product_ID} of the {@code Product}
     */

    public static void printProduct(Product[] catalouge, short ID){
        for (Product product:catalouge) {
            if (product.getProduct_ID()==ID){
                System.out.println(product);
                break;
            }
        }
    }

    /**
     * Sort a {@code Product[]} array by property {@code Product_Price} (in ascending order)
     * @param catalouge {@code Product[]} array
     */
    public static void sortProductsbyPrice(Product[] catalouge){
        Arrays.sort(catalouge, Comparator.comparingDouble(Product::getProduct_Price)); //one-liner for sorting objects in ascending order by a property, available from Java 8
    }
    /**
     * Sort a {@code Product[]} array by property {@code Product_Name} (in ascending order)
     * @param catalouge {@code Product[]} array
     */
    public static void sortProductsbyName(Product[] catalouge){
        Arrays.sort(catalouge, Comparator.comparing(Product::getProduct_Name)); //sort Product[] by the ascending lexicographical order of Product.getProduct_Name()
    }
    /**
     * Sort a {@code Product[]} array by property Product_Manufacturer (in ascending order)
     * @param catalouge {@code Product[]} array
     */
    public static void sortProductsbyManufacturer(Product[] catalouge){
        Arrays.sort(catalouge, Comparator.comparing(Product::getProduct_Manufacturer)); //sort Product[] by the ascending lexicographical order of Product.getProduct_Manufacturer()
    }

    /**
     * Search for a Product in a {@code Product[]} array given its {@code Product_ID}
     * @param catalouge {@code Product[]} array
     * @param ID {@code Product_ID} of the Product needed
     * @return Product if product is found, otherwise returns {@code null}
     */
    public static Product searchProduct(Product[] catalouge,short ID) {
        Product result = null;
        for (Product product : catalouge) {
            if (product.getProduct_ID() == ID) {
                result = product;
                break;
            }
        }
        //if the ID cannot be found, result stays null
        return result;
    }

    /**
     * Update parameters of a {@code Product} in a {@code Product[]} array with parameters below given its {@code Product_ID}.<br>
     * If update to a parameter is not needed, use {@code null} and {@code NaN} for String and Number parameter respectively
     * @param catalouge {@code Product[]} array that has the {@code Product} needed to be updated
     * @param ID {@code Product_ID} of the {@code Product}
     * @param category Updated value for {@code Product_Category}, sets to {@code null} if update is not needed
     * @param name Updated value for {@code Product_Name}, sets to {@code null} if update is not needed
     * @param price Updated value for {@code Product_Price}, sets to {@code NaN} if update is not needed
     * @param manufacturer Updated value for {@code Product_Manufacturer}, sets to {@code null} if update is not needed
     * @param description Updated value for {@code Product_Description}, sets to {@code null} if update is not needed
     */
    public static void updateProduct(Product[] catalouge, short ID, Category category, String name, double price, String manufacturer, String description){
        if (ID > catalouge.length || ID < 0) {
            System.out.println("Can't update a product that doesn't exist!");
            return;
        }
        for (Product product:catalouge) {
            if (product.getProduct_ID()==ID){
                if (category != null) product.setProduct_Category(category);
                if (name != null) product.setProduct_Name(name);
                if (!Double.isNaN(price)) product.setProduct_Price(price);
                if (manufacturer != null) product.setProduct_Manufacturer(manufacturer);
                if (description != null) product.setProduct_Description(description);
                break;
            }
        }
    }

    /**
     * Removes a {@code Product} from a {@code Product[]} array given its {@code Product_ID}
     * @param catalouge {@code Product[]} array
     * @param ID {@code Product_ID} of the {@code Product} need to be deleted
     * @return new {@code Product[]} array to be reassigned to the old array
     */
    public static Product[] deleteProduct(Product[] catalouge, short ID){
        return Arrays.stream(catalouge).filter(product -> product.getProduct_ID()!=ID).toArray(Product[]::new); //one-liner to remove object from an array using Java stream (available from Java 8)
    }

    /**
     * Prints out the number of each type of product in a {@code Product[]} array
     * @param catalouge {@code Product[]} array
     */
    public static void printAnalytic(Product[] catalouge){
        short countWOODFUTNITURE=0,countTILES=0;
        for (Product product:catalouge) {
            switch (product.getProduct_Category()) {
                case TILES -> countTILES++;
                case WOODFURNITURE -> countWOODFUTNITURE++;
            }
        }
        System.out.println("Furniture: "+countWOODFUTNITURE+"\nTiles: "+countTILES);
    }
}
