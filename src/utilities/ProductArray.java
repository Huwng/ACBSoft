package utilities;

import objects.*;

import java.util.*;

public class ProductArray {
    /**
     * Generate an array of predefined {@code "n"} products
     * @param n the number of products need to be generated
     * @return an {@code ArrayList} of {@code Product} objects ({@code ArrayList<Product>})
     */
    public static ArrayList<Product> generateProducts(int n){
        //initiate our "catalogue"
        ArrayList<Product> catalogue = new ArrayList<>();
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
        final int WoodTypeSize = WoodType.values().length;
        //initiate random engine
        final Random random = new Random();
        //for-index loop through the product catalogue to set the properties of each product
        for (int i = 0; i < n; i++) {
            Product product = null;
            switch (Category.values()[random.nextInt(CategorySize - 1) + 1]) {
                case TILES -> product = new Tiles(random.nextDouble()*100,random.nextDouble()*100);
                case WOODFURNITURE -> product = new WoodFurniture(random.nextDouble()*100,WoodType.values()[random.nextInt(WoodTypeSize)]);
            }
            if (product == null) {i--;continue;}; //if somehow product is null after the switch statement (which it shouldn't be), decrease i to retry. Code is added to avoid using "assert", but a null check should NOT have been here either way.
            if (product.getProduct_Category() == Category.WOODFURNITURE) {
                product.setProduct_Name(WOODFURNITURE_product_Name[random.nextInt(WOODFURNITURE_product_Name.length)]);

            } else if (product.getProduct_Category() == Category.TILES) {
                product.setProduct_Name(TILES_product_Name[random.nextInt(TILES_product_Name.length)]);
            }
            product.setProduct_ID(index);
            product.setProduct_Price(product.calculatePrice());
            product.setProduct_Manufacturer(product_manufacturer[random.nextInt(product_manufacturer.length)]);
            catalogue.add(product);
            index++;
        }
        return catalogue;
    }

    /**
     * Prints out a {@code ArrayList<Product>} array to {@code System.out}
     * @param catalogue {@code ArrayList<Product>} array
     */
    public static void printProducts(ArrayList<Product> catalogue){
        for (Product product:catalogue) {
            System.out.println(product);
        }
    }

    /**
     * Prints out a {@code Product} in a {@code ArrayList<Product>} array given its {@code Product_ID}
     * @param catalogue {@code ArrayList<Product>} array
     * @param ID {@code Product_ID} of the {@code Product}
     */

    public static void printProduct(ArrayList<Product> catalogue, short ID){
        for (Product product:catalogue) {
            if (product.getProduct_ID()==ID){
                System.out.println(product);
                break;
            }
        }
    }

    /**
     * Sort a {@code ArrayList<Product>} array by property {@code Product_Price} (in ascending order)
     * @param catalogue {@code ArrayList<Product>} array
     */
    public static void sortProductsbyPrice(ArrayList<Product> catalogue){
        catalogue.sort(Comparator.comparing(Product::getProduct_Price));
    }
    /**
     * Sort a {@code ArrayList<Product>} array by property {@code Product_Name} (in ascending order)
     * @param catalogue {@code ArrayList<Product>} array
     */
    public static void sortProductsbyName(ArrayList<Product> catalogue){
        catalogue.sort(Comparator.comparing(Product::getProduct_Name));
    }
    /**
     * Sort a {@code ArrayList<Product>} array by property Product_Manufacturer (in ascending order)
     * @param catalogue {@code ArrayList<Product>} array
     */
    public static void sortProductsbyManufacturer(ArrayList<Product> catalogue){
        catalogue.sort(Comparator.comparing(Product::getProduct_Manufacturer));
    }

    /**
     * Search for a Product in a {@code ArrayList<Product>} array given its {@code Product_ID}
     * @param catalogue {@code ArrayList<Product>} array
     * @param ID {@code Product_ID} of the Product needed
     * @return {@code Product} if product is found, otherwise returns {@code null}
     */
    public static Product searchProduct(ArrayList<Product> catalogue,short ID) {
        Product result = null;
        for (Product product : catalogue) {
            if (product.getProduct_ID() == ID) {
                result = product;
                break;
            }
        }
        //if the ID cannot be found, result stays null
        return result;
    }

    /**
     * Update a {@code Product} in {@code ArrayList<Product>} array to be a {@code Tiles} product
     * @param catalogue {@code ArrayList<Product>} array that has the {@code Product} needed to be updated
     * @param ID {@code Product_ID} of the {@code Product}
     * @param name Updated value for {@code Product_Name}, sets to {@code null} if update is not needed
     * @param price Updated value for {@code Product_Price}, sets to {@code NaN} if update is not needed
     * @param manufacturer Updated value for {@code Product_Manufacturer}, sets to {@code null} if update is not needed
     * @param description Updated value for {@code Product_Description}, sets to {@code null} if update is not needed
     * @param side1 Updated value for {@code side1}
     * @param side2 Updated value for {@code side2}
     */
    public static void updateTilesProduct(ArrayList<Product> catalogue, short ID, String name, double price, String manufacturer, String description, double side1, double side2){
        if (ID > catalogue.size() || ID < 0) {
            System.out.println("Can't update a product that doesn't exist!");
            return;
        }
        for (int i = 0, catalogueLength = catalogue.size(); i < catalogueLength; i++) {
            if (catalogue.get(i).getProduct_ID() == ID) {
                catalogue.set(i, new Tiles(side1, side2));
                catalogue.get(i).setProduct_ID(ID);
                if (name != null) catalogue.get(i).setProduct_Name(name);
                if (!Double.isNaN(price)) catalogue.get(i).setProduct_Price(price);
                else catalogue.get(i).setProduct_Price(catalogue.get(i).calculatePrice());
                if (manufacturer != null) catalogue.get(i).setProduct_Manufacturer(manufacturer);
                if (description != null) catalogue.get(i).setProduct_Description(description);
                break;
            }
        }
    }

    /**
     * Update a {@code Product} in {@code ArrayList<Product>} array to be a {@code WoodFurniture} product
     * @param catalogue {@code ArrayList<Product>} array that has the {@code Product} needed to be updated
     * @param ID {@code Product_ID} of the {@code Product}
     * @param name Updated value for {@code Product_Name}, sets to {@code null} if update is not needed
     * @param price Updated value for {@code Product_Price}, sets to {@code NaN} if update is not needed
     * @param manufacturer Updated value for {@code Product_Manufacturer}, sets to {@code null} if update is not needed
     * @param description Updated value for {@code Product_Description}, sets to {@code null} if update is not needed
     * @param weight Updated value for {@code weight}
     * @param woodType Updated value for {@code woodType}
     */
    public static void updateFurnitureProduct(ArrayList<Product> catalogue, short ID, String name, double price, String manufacturer, String description, double weight, WoodType woodType){
        if (ID > catalogue.size() || ID < 0) {
            System.out.println("Can't update a product that doesn't exist!");
            return;
        }
        for (int i = 0, catalogueLength = catalogue.size(); i < catalogueLength; i++) {
            if (catalogue.get(i).getProduct_ID() == ID) {
                catalogue.set(i, new WoodFurniture(weight, woodType));
                catalogue.get(i).setProduct_ID(ID);
                if (name != null) catalogue.get(i).setProduct_Name(name);
                if (!Double.isNaN(price)) catalogue.get(i).setProduct_Price(price);
                else catalogue.get(i).setProduct_Price(catalogue.get(i).calculatePrice());
                if (manufacturer != null) catalogue.get(i).setProduct_Manufacturer(manufacturer);
                if (description != null) catalogue.get(i).setProduct_Description(description);
                break;
            }
        }
    }

    /**
     * Removes a {@code Product} from a {@code ArrayList<Product>} array given its {@code Product_ID}
     * @param catalogue {@code ArrayList<Product>} array
     * @param ID {@code Product_ID} of the {@code Product} need to be deleted
     * //@return new {@code ArrayList<Product>} array to be reassigned to the old array
     */
    public static void deleteProduct(ArrayList<Product> catalogue, short ID){
        catalogue.removeIf(product -> product.getProduct_ID() == ID);
    }

    /**
     * Prints out the number of each type of product in a {@code ArrayList<Product>} array
     * @param catalogue {@code ArrayList<Product>} array
     */
    public static void printAnalytic(ArrayList<Product> catalogue){
        short countWOODFUTNITURE=0,countTILES=0;
        for (Product product:catalogue) {
            switch (product.getProduct_Category()) {
                case TILES -> countTILES++;
                case WOODFURNITURE -> countWOODFUTNITURE++;
            }
        }
        System.out.println("Furniture: "+countWOODFUTNITURE+"\nTiles: "+countTILES);
    }
}
