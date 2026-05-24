package module.hw.repository.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import module.hw.model.Order;
import module.hw.repository.OrderRepository;

public class OrderRepositoryInMemory implements OrderRepository {

  private final Map<Integer, Order> orders = new HashMap<>();

  @Override
  public int saveOrder(Order order) {
    if (order == null) {
      throw new IllegalArgumentException("Order cannot be null");
    }

    if (order.getId() < 0) {
      throw new IllegalArgumentException("Id cannot be negative");
    }

    if (orders.containsKey(order.getId())) {
      throw new IllegalArgumentException(
        "Order with id " + order.getId() + " already exists"
      );
    }

    orders.put(order.getId(), order);
    return order.getId();
  }

  @Override
  public Optional<Order> findOrderById(int id) {
    if (id < 0) {
      throw new IllegalArgumentException("Id cannot be negative");
    }

    return Optional.ofNullable(orders.get(id));
  }
}
