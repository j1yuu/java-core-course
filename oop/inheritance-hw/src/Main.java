class Parent {
  protected String name;
  protected int age;

  public Parent(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void sayHello() {
    System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
  }
}

class Child extends Parent {
  public Child(String name, int age) {
    super(name, age);
  }

  @Override
  public void sayHello() {
    System.out.println("Hi, I'm " + name);
  }
}

public class Main {
    public static void main(String[] args) {
      Parent parent = new Parent("John", 35);
      Parent child = new Child("Jane", 12);

      parent.sayHello();
      child.sayHello();
    }
}
