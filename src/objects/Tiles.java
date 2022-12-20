package objects;

public class Tiles extends Product {
    //properties
    private double side1;
    private double side2;
    //constructor

    public Tiles() {
    }

    public Tiles(double side1, double side2){
        this.side1=side1;
        this.side2=side2;
        super.setProduct_Category(Category.TILES);
    }

    public Tiles(short product_ID, String product_Name, double product_Price, double side1, double side2) {
        super(product_ID, product_Name, product_Price);
        this.side1 = side1;
        this.side2 = side2;
        super.setProduct_Category(Category.TILES);
    }

    public Tiles(short product_ID, String product_Name, double product_Price, String product_Manufacturer, double side1, double side2) {
        super(product_ID, product_Name, product_Price, product_Manufacturer);
        this.side1 = side1;
        this.side2 = side2;
        super.setProduct_Category(Category.TILES);
    }

    public Tiles(short product_ID, Category product_Category, String product_Name, double product_Price, String product_Manufacturer, String product_Description, double side1, double side2) {
        super(product_ID, product_Category, product_Name, product_Price, product_Manufacturer, product_Description);
        this.side1 = side1;
        this.side2 = side2;
        super.setProduct_Category(Category.TILES);
    }
    //getter & setter

    public double getSide1() {
        return side1;
    }

    public Tiles setSide1(double side1) {
        this.side1 = side1;
        return this;
    }

    public double getSide2() {
        return side2;
    }

    public Tiles setSide2(double side2) {
        this.side2 = side2;
        return this;
    }

    //overridden method

    @Override
    public String toString() {
        return  super.toString() + " | Tiles{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                "}";
    }

    @Override
    public double calculatePrice() {
        return this.getSide1()*this.getSide2()*36;
    }
}
