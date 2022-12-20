package objects;

public class WoodFurniture extends Product{
    //properties
    private double weight;
    private WoodType woodType;
    //constructor
    public WoodFurniture(){};

    public WoodFurniture(double weight, WoodType woodType){
        this.woodType = woodType;
        this.weight = weight;
        super.setProduct_Category(Category.WOODFURNITURE);
    };

    public WoodFurniture(short product_ID, String product_Name, double product_Price, double weight, WoodType woodType) {
        super(product_ID, product_Name, product_Price);
        this.weight = weight;
        this.woodType = woodType;
        super.setProduct_Category(Category.WOODFURNITURE);
    }

    public WoodFurniture(short product_ID, String product_Name, double product_Price, String product_Manufacturer, double weight, WoodType woodType) {
        super(product_ID, product_Name, product_Price, product_Manufacturer);
        this.weight = weight;
        this.woodType = woodType;
        super.setProduct_Category(Category.WOODFURNITURE);
    }

    public WoodFurniture(short product_ID, Category product_Category, String product_Name, double product_Price, String product_Manufacturer, String product_Description, double weight, WoodType woodType) {
        super(product_ID, product_Category, product_Name, product_Price, product_Manufacturer, product_Description);
        this.weight = weight;
        this.woodType = woodType;
        super.setProduct_Category(Category.WOODFURNITURE);
    }
    //getter & setter

    public double getWeight() {
        return weight;
    }

    public WoodFurniture setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    public WoodFurniture setWoodType(WoodType woodType) {
        this.woodType = woodType;
        return this;
    }

    //overridden method

    @Override
    public String toString() {
        return  super.toString() + " | WoodFurniture{" +
                "weight=" + this.weight +
                ", woodType=" + this.woodType +
                "}";
    }

    @Override
    public double calculatePrice() {
        return this.getWeight()*(this.getWoodType().ordinal()+1)*10;
    }
}
