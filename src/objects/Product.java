package objects;

import java.util.Objects;

public class Product {
    //constants
    public static final short PRODUCT_ID = 0;
    public static final Category PRODUCT_CATEGORY = Category.DEFAULT;
    public static final String PRODUCT_NAME = "Example Product_Name";
    public static final double PRODUCT_PRICE = 0.0;
    public static final String PRODUCT_MANUFACTURER = "Example Product_Manufacturer";
    public static final String PRODUCT_DESCRIPTION = "Example Product_Description";
    //properties
    private short Product_ID;
    private Category Product_Category;
    private String Product_Name;
    private double Product_Price;
    private String Product_Manufacturer;
    private String Product_Description;

    //constructor
    public Product() {
        this(PRODUCT_ID, PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_MANUFACTURER, PRODUCT_DESCRIPTION);
    }

    public Product(short product_ID, String product_Name, double product_Price) {
        this(product_ID, PRODUCT_CATEGORY, product_Name, product_Price, PRODUCT_MANUFACTURER, PRODUCT_DESCRIPTION);
    }

    public Product(short product_ID, String product_Name, double product_Price, String product_Manufacturer) {
        this(product_ID, PRODUCT_CATEGORY, product_Name, product_Price, product_Manufacturer, PRODUCT_DESCRIPTION);
    }

    public Product(short product_ID, Category product_Category, String product_Name, double product_Price, String product_Manufacturer, String product_Description) {
        this.Product_ID = product_ID;
        this.Product_Category = product_Category;
        this.Product_Name = product_Name;
        this.Product_Price = product_Price;
        this.Product_Manufacturer = product_Manufacturer;
        this.Product_Description = product_Description;
    }

    //getter
    public short getProduct_ID() {
        return this.Product_ID;
    }

    public Category getProduct_Category() {
        return this.Product_Category;
    }

    public String getProduct_Name() {
        return this.Product_Name;
    }

    public double getProduct_Price() {
        return this.Product_Price;
    }

    public String getProduct_Manufacturer() {
        return this.Product_Manufacturer;
    }

    public String getProduct_Description() {
        return this.Product_Description;
    }

    //setter
    public Product setProduct_ID(short product_ID) {
        this.Product_ID = product_ID;
        return this;
    }

    public Product setProduct_Category(Category product_Category) {
        this.Product_Category = product_Category;
        return this;
    }

    public Product setProduct_Name(String product_Name) {
        this.Product_Name = product_Name;
        return this;
    }

    public Product setProduct_Price(double product_Price) {
        this.Product_Price = product_Price;
        return this;
    }

    public Product setProduct_Manufacturer(String product_Manufacturer) {
        this.Product_Manufacturer = product_Manufacturer;
        return this;
    }

    public Product setProduct_Description(String product_Description) {
        this.Product_Description = product_Description;
        return this;
    }

    //other methods

    @Override
    public String toString() {
        return "Product{" +
                "Product_ID=" + this.Product_ID +
                ", Product_Category=" + this.Product_Category +
                ", Product_Name='" + this.Product_Name + '\'' +
                ", Product_Price=" + this.Product_Price +
                ", Product_Manufacturer=" + this.Product_Manufacturer +
                ", Product_Description='" + this.Product_Description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Product_ID == product.Product_ID && Double.compare(product.Product_Price, Product_Price) == 0 && Product_Category == product.Product_Category && Objects.equals(Product_Name, product.Product_Name) && Objects.equals(Product_Manufacturer, product.Product_Manufacturer) && Objects.equals(Product_Description, product.Product_Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Product_ID, Product_Category, Product_Name, Product_Price, Product_Manufacturer, Product_Description);
    }

    //cleanup method
    @Override
    @SuppressWarnings("removal")
    protected void finalize() throws Throwable {
        try {
            System.out.println("removing..");
        } finally {
            super.finalize();
        }
    }
}
