package junit.basics.hw.discount;

public class DiscountCalculator {
  public static double calculate(double price, double discount) {
    if (discount > 1.0 || discount < 0.0) throw new IllegalArgumentException();

    return price * (1 - discount);
  }
}
