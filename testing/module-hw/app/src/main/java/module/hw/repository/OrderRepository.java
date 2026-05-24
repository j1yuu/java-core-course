package module.hw.repository;

import java.util.Optional;
import module.hw.model.Order;

public interface OrderRepository {
  int saveOrder(Order order);
  Optional<Order> findOrderById(int id);
}
