package main.seed;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import main.model.Customer;
import main.model.Order;
import main.model.Product;

public class Seed {
  public static void seedProducts(List<Product> products) {
    products.addAll(
      List.of(
        new Product(1L, "Clean Code", "Books", BigDecimal.valueOf(120.0)),
        new Product(2L, "Effective Java", "Books", BigDecimal.valueOf(150.0)),
        new Product(3L, "Java Basics", "Books", BigDecimal.valueOf(80.0)),
        new Product(4L, "Spring in Action", "Books", BigDecimal.valueOf(95.0)),
        new Product(5L, "Algorithms", "Books", BigDecimal.valueOf(200.0)),

        new Product(6L, "Мастер и Маргарита", "Книги", BigDecimal.valueOf(70.0)),
        new Product(7L, "Преступление и наказание", "Книги", BigDecimal.valueOf(90.0)),
        new Product(8L, "Война и мир", "Книги", BigDecimal.valueOf(110.0)),

        new Product(9L, "Lego Classic", "Toys", BigDecimal.valueOf(50.0)),
        new Product(10L, "Toy Car", "Toys", BigDecimal.valueOf(30.0)),
        new Product(11L, "Doll House", "Toys", BigDecimal.valueOf(75.0)),
        new Product(12L, "Puzzle", "Toys", BigDecimal.valueOf(20.0)),

        new Product(13L, "Baby Stroller", "Children's products", BigDecimal.valueOf(300.0)),
        new Product(14L, "Kids Backpack", "Children's products", BigDecimal.valueOf(45.0)),
        new Product(15L, "Baby Bottle", "Children's products", BigDecimal.valueOf(15.0)),

        new Product(16L, "Laptop", "Electronics", BigDecimal.valueOf(900.0)),
        new Product(17L, "Headphones", "Electronics", BigDecimal.valueOf(100.0)),
        new Product(18L, "Coffee Machine", "Home", BigDecimal.valueOf(250.0))
      )
    );
  }

  public static void seedOrders(List<Order> orders, List<Product> products) {
    if (products.isEmpty()) {
      seedProducts(products);
    }

    orders.addAll(
      List.of(
        new Order(
            1L,
            LocalDate.of(2021, 2, 1),
            LocalDate.of(2021, 2, 4),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(0),  // Clean Code
                products.get(8),  // Lego Classic
                products.get(12)  // Baby Stroller
            ))
        ),
        new Order(
            2L,
            LocalDate.of(2021, 2, 10),
            LocalDate.of(2021, 2, 15),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(1),  // Effective Java
                products.get(9),  // Toy Car
                products.get(13)  // Kids Backpack
            ))
        ),
        new Order(
            3L,
            LocalDate.of(2021, 2, 28),
            LocalDate.of(2021, 3, 5),
            "SHIPPED",
            new HashSet<>(List.of(
                products.get(2),  // Java Basics
                products.get(10), // Doll House
                products.get(14)  // Baby Bottle
            ))
        ),
        new Order(
            4L,
            LocalDate.of(2021, 3, 14),
            LocalDate.of(2021, 3, 18),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(3),  // Spring in Action
                products.get(11), // Puzzle
                products.get(15)  // Laptop
            ))
        ),
        new Order(
            5L,
            LocalDate.of(2021, 3, 14),
            LocalDate.of(2021, 3, 19),
            "PROCESSING",
            new HashSet<>(List.of(
                products.get(4),  // Algorithms
                products.get(16), // Headphones
                products.get(17)  // Coffee Machine
            ))
        ),
        new Order(
            6L,
            LocalDate.of(2021, 3, 15),
            LocalDate.of(2021, 3, 20),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(5),  // Мастер и Маргарита
                products.get(12), // Baby Stroller
                products.get(8)   // Lego Classic
            ))
        ),
        new Order(
            7L,
            LocalDate.of(2021, 3, 15),
            LocalDate.of(2021, 3, 22),
            "NEW",
            new HashSet<>(List.of(
                products.get(6),  // Преступление и наказание
                products.get(13), // Kids Backpack
                products.get(9)   // Toy Car
            ))
        ),
        new Order(
            8L,
            LocalDate.of(2021, 3, 20),
            LocalDate.of(2021, 3, 25),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(7),  // Война и мир
                products.get(1),  // Effective Java
                products.get(10)  // Doll House
            ))
        ),
        new Order(
            9L,
            LocalDate.of(2021, 4, 1),
            LocalDate.of(2021, 4, 5),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(0),  // Clean Code
                products.get(4),  // Algorithms
                products.get(15)  // Laptop
            ))
        ),
        new Order(
            10L,
            LocalDate.of(2021, 4, 10),
            LocalDate.of(2021, 4, 15),
            "CANCELLED",
            new HashSet<>(List.of(
                products.get(2),  // Java Basics
                products.get(11), // Puzzle
                products.get(17)  // Coffee Machine
            ))
        ),
        new Order(
            11L,
            LocalDate.of(2021, 5, 1),
            LocalDate.of(2021, 5, 5),
            "DELIVERED",
            new HashSet<>(List.of(
                products.get(3),  // Spring in Action
                products.get(14), // Baby Bottle
                products.get(16)  // Headphones
            ))
        ),
        new Order(
            12L,
            LocalDate.of(2021, 5, 20),
            LocalDate.of(2021, 5, 25),
            "PROCESSING",
            new HashSet<>(List.of(
                products.get(4),  // Algorithms
                products.get(8),  // Lego Classic
                products.get(15)  // Laptop
            ))
        )
      )
    );
  }

  public static void seedUsers(List<Customer> customers, List<Order> orders, List<Product> products) {
    if (products.isEmpty()) {
      seedProducts(products);
    }

    if (orders.isEmpty()) {
      seedOrders(orders, products);
    }

    customers.addAll(
      List.of(
        new Customer(
            1L,
            "Иван Петров",
            1L,
            new HashSet<>(List.of(
                orders.get(0),
                orders.get(1)
            ))
        ),
        new Customer(
            2L,
            "Мария Иванова",
            2L,
            new HashSet<>(List.of(
                orders.get(2),
                orders.get(3),
                orders.get(4)
            ))
        ),
        new Customer(
            3L,
            "Алексей Смирнов",
            2L,
            new HashSet<>(List.of(
                orders.get(5),
                orders.get(6),
                orders.get(7)
            ))
        ),
        new Customer(
            4L,
            "Елена Козлова",
            3L,
            new HashSet<>(List.of(
                orders.get(8),
                orders.get(9)
            ))
        ),
        new Customer(
            5L,
            "Дмитрий Соколов",
            4L,
            new HashSet<>(List.of(
                orders.get(10),
                orders.get(11)
            ))
        )
      )
    );
  }
}