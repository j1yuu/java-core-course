package model;

import java.util.Objects;

/**
 * Абстрактный класс Countable.
 * 
 * <p>Используется для создания на его основе конкретных реализаций классов, которые можно посчитать.</p>
 * 
 * @param availableCopies {@code int availableCopies} Количество доступных экземпляров
 * 
 * <p>Пример использования:</p>
 * 
 * <pre>
 * {@code
 *  class Book extends Countable {
 *    public Book(int availableCopies) {
 *      super(availableCopies);
 *   }
 *  }
 * }
 * </pre>
 */
abstract class Countable {
  private int availableCopies;

  public Countable(int availableCopies) {
    validateAvailableCopies(availableCopies);

    this.availableCopies = availableCopies;
  }

  public int getAvailableCopies() {
    return availableCopies;
  }

  private boolean validateAvailableCopies(int availableCopies) {
    if (availableCopies < 0) throw new IllegalArgumentException("Available copies should be greater or equal to 0. Current input: " + availableCopies);
    return true;
  }

  public void setAvailableCopies(int availableCopies) {
    validateAvailableCopies(availableCopies);

    this.availableCopies = availableCopies;
  }

  @Override
  public String toString() {
    return "Countable{" +
      "availableCopies=" + availableCopies +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Countable countable = (Countable) o;

    return availableCopies == countable.availableCopies;
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableCopies);
  }
}