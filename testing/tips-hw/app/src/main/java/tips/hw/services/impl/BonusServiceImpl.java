package tips.hw.services.impl;

import tips.hw.services.BonusService;

public class BonusServiceImpl implements BonusService {
  
  @Override
  public int calculateBonusPoints(double purchaseAmount) {
      if (purchaseAmount < 0) {
          throw new IllegalArgumentException("Purchase amount cannot be negative");
      }

      return (int) (purchaseAmount / 100);
  }
  
}
