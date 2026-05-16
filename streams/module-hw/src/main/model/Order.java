package main.model;

import java.time.LocalDate;
import java.util.Set;

public class Order {
  private final Long id;
  private final LocalDate orderDate;
  private final LocalDate deliveryDate;
  private final String status;
  private final Set<Product> products;

  public Order(Long id, LocalDate orderDate, LocalDate deliveryDate, String status, Set<Product> products) {
    this.id = id;
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
    this.status = status;
    this.products = products;
  }

  public Long getId() {
    return id;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public String getStatus() {
    return status;
  }

  public Set<Product> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", status=" + status
        + ", products=" + products + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
