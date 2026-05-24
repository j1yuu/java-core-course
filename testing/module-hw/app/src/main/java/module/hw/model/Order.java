package module.hw.model;

public class Order {

  private final int id;
  private String productName;
  private int qunatity;
  private double unitPrice;

  public Order(int id, String productName, int quantity, double unitPrice) {
    this.id = id;
    this.productName = productName;
    this.qunatity = quantity;
    this.unitPrice = unitPrice;
  }

  public int getId() {
    return this.id;
  }

  public String getProductName() {
    return this.productName;
  }

  public int getQuantity() {
    return this.qunatity;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setQuantity(int quantity) {
    this.qunatity = quantity;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Order obj = (Order) o;

    return id == obj.getId();
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public String toString() {
    return (
      "Order{" +
      "id=" +
      id +
      ", productName='" +
      productName +
      '\'' +
      ", qunatity=" +
      qunatity +
      ", unitPrice=" +
      unitPrice +
      '}'
    );
  }
}
