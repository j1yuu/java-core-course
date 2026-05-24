package module.hw.service.impl;

import java.util.Optional;
import module.hw.exceptions.OrderNotFoundException;
import module.hw.model.Order;
import module.hw.repository.OrderRepository;
import module.hw.service.OrderService;

public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public String processOrder(Order order) {
    int orderId = orderRepository.saveOrder(order);
    if (orderId > 0) {
      return "Order processed successfully, orderId: " + orderId;
    } else {
      return "Order processing failed";
    }
  }

  @Override
  public double calculateTotal(int id) {
    Optional<Order> order = orderRepository.findOrderById(id);

    if (order.isPresent()) {
      Order o = order.get();
      return o.getUnitPrice() * o.getQuantity();
    } else {
      throw new OrderNotFoundException("Order not found with id: " + id);
    }
  }
}
