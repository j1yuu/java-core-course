package module.hw.service;

import module.hw.model.Order;

public interface OrderService {
  String processOrder(Order order);
  double calculateTotal(int id);
}
