package main.model;

import java.math.BigDecimal;

public class Product {
  private final Long id;
  private final String name;
  private final String category;
  private final BigDecimal price;

  public Product(Long id, String name, String category, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
  }

  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getCategory() {
    return category;
  }
  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
}
