abstract class Animal {

  abstract void makeSound();

  abstract void eat();

  void sleep() {
    System.out.println("Zzz...");
  }
}

interface Swimmable {
  void swim();
}

class Pigeon extends Animal {

  @Override
  void makeSound() {
    System.out.println("Tweet...");
  }

  @Override
  void eat() {
    System.out.println("Eating semechki...");
  }
}

class Fish extends Animal implements Swimmable {

  @Override
  void makeSound() {
    System.out.println("Blub...");
  }

  @Override
  void eat() {
    System.out.println("Eating...");
  }

  @Override
  public void swim() {
    System.out.println("Swimming...");
  }
}

public class Main {

  public static void main(String[] args) {
    Animal pigeon = new Pigeon();
    Animal fish = new Fish();

    Animal[] animals = { pigeon, fish };

    for (Animal animal : animals) {
      animal.makeSound();
      animal.eat();
      animal.sleep();

      if (animal instanceof Swimmable) {
        ((Swimmable) animal).swim();
      }
    }
  }
}
