package mockito.hw.services.impl;

import mockito.hw.services.NotificationService;
import mockito.hw.services.OrderService;
import mockito.hw.services.PaymentService;

public class OrderServiceImpl implements OrderService {
  private final PaymentService paymentService;
  private final NotificationService notificationService;
  
  public OrderServiceImpl(PaymentService paymentService, NotificationService notificationService) {
    this.paymentService = paymentService;
    this.notificationService = notificationService;
  }

    @Override
    public boolean placeOrder(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Order amount must be greater than zero");
        }

        boolean paymentSuccessful = paymentService.makePayment(amount);

        if (paymentSuccessful) {
            notificationService.sendNotification("Order was successfully created");
            return true;
        }

        return false;
    }
}
