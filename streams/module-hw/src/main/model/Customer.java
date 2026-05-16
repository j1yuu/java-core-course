package main.model;

import java.util.Set;

public class Customer {
  private final Long id;
  private final String name;
  private final Long level;
  private final Set<Order> orders;

  public Customer(Long id, String name, Long level, Set<Order> orders) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.orders = orders;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getLevel() {
    return level;
  }

  public Set<Order> getOrders() {
    return orders;
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
    Customer other = (Customer) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
