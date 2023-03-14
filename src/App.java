import java.util.ArrayList;

class Product {
  protected String name;
  protected String category;
  protected double price;
  protected int quantity;

  public Product(String name, String category, double price, int quantity) {
    this.name = name;
    this.category = category;
    this.price = price;
    this.quantity = quantity;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return this.category;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public String toString() {
    return this.name + " - " + this.category + " - " + this.price + " - " + this.quantity + " units";
  }

  public double getTotalPrice() {
    return this.price * this.quantity;
  }
}

class ElectronicProduct extends Product {
  protected String brand;
  protected String model;

  public ElectronicProduct(String name, String category, double price, int quantity, String brand, String model) {
    super(name, category, price, quantity);
    this.brand = brand;
    this.model = model;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getModel() {
    return this.model;
  }

  public String toString() {
    return super.toString() + " - " + this.brand + " - " + this.model;
  }
}

class NonElectronicProduct extends Product {
  protected String material;

  public NonElectronicProduct(String name, String category, double price, int quantity, String material) {
    super(name, category, price, quantity);
    this.material = material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getMaterial() {
    return this.material;
  }

  public String toString() {
    return super.toString() + " - " + this.material;
  }
}

public class App {
  static void printElectronicProducts(ArrayList<ElectronicProduct> products) {
    String format = "%-12s %-15s %-10s %-12s %-10s %-5s %-10s";
    System.out.println("------------Electronic Product------------");
    System.out.println(
        String.format(format, "Name", "Category", "Brand", "Model", "Price",
            "Qty", "Total Price"));
    for (ElectronicProduct product : products) {
      System.out.println(String.format(format, product.getName(), product.getCategory(),
          product.getBrand(), product.getModel(), product.getPrice(),
          product.getQuantity(), product.getTotalPrice()));
    }
    System.out.println("\n");
  }

  static void printNonElectronicProducts(ArrayList<NonElectronicProduct> products) {
    String format = "%-15s %-10s %-10s %-10s %-5s %-10s";
    System.out.println("----------Non Electronic Product----------");
    System.out.println(String.format(format, "Name", "Category", "Material", "Price",
        "Qty", "Total Price"));
    for (NonElectronicProduct product : products) {
      System.out.println(String.format(format, product.getName(), product.getCategory(),
          product.getMaterial(), product.getPrice(),
          product.getQuantity(), product.getTotalPrice()));
    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    ArrayList<ElectronicProduct> electronicProducts = new ArrayList<ElectronicProduct>();
    ArrayList<NonElectronicProduct> nonElectronicProducts = new ArrayList<NonElectronicProduct>();

    electronicProducts.add(new ElectronicProduct("iPhone", "Mobile Phone", 999.99, 5, "Apple", "12 Pro Max"));
    electronicProducts.add(new ElectronicProduct("MacBook Pro", "Laptop", 2999.99, 3, "Apple", "M1 Pro"));
    nonElectronicProducts.add(new NonElectronicProduct("Office Chair", "Furniture", 149.99, 10, "Leather"));
    nonElectronicProducts.add(new NonElectronicProduct("Office Table", "Furniture", 199.99, 5, "Wood"));

    System.out.println("\n");
    printElectronicProducts(electronicProducts);
    printNonElectronicProducts(nonElectronicProducts);
  }
}