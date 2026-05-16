package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import main.model.Customer;
import main.model.Order;
import main.model.Product;
import main.seed.Seed;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Seed.seedUsers(customers, orders, products);

        // Task 1
        List<Product> task1 = products.stream()
            .filter(p -> p.getCategory().equals("Books") && p.getPrice()
            .compareTo(BigDecimal.valueOf(100.0)) > 0)
            .toList();

        // Task 2
        List<Order> task2 = orders.stream()
            .filter(o -> o.getProducts().stream().anyMatch(c -> "Children's products".equals(c.getCategory()))).toList();

        // Task 3
        BigDecimal task3 = products.stream()
            .filter(p -> p.getCategory().equals("Toys"))
            .map(p -> BigDecimal.valueOf(0.9).multiply(p.getPrice()))
            .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        
        // Task 4
        List<Product> task4 = customers.stream()
            .filter(c -> c.getLevel().equals(2L))
            .flatMap(c -> c.getOrders().stream())
            .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 02, 01)) && o.getOrderDate().isBefore(LocalDate.of(2021, 04, 01)))
            .flatMap(o -> o.getProducts().stream())
            .toList();
        
        // Task 5
        List<Product> task5 = products.stream()
            .filter(p -> p.getCategory().equals("Books"))
            .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
            .limit(2)
            .toList();

        // Task 6
        List<Order> task6 = orders.stream()
            .filter(o -> o.getStatus().equals("DELIVERED"))
            .sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate()))
            .limit(3)
            .toList();
        
        // Task 7
        List<Order> task7 = orders.stream()
            .filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 03, 15)))
            .peek(o -> System.out.println(o.getId()))
            .toList();

        // Task 8
        BigDecimal task8 = orders.stream()
            .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 01, 31)) && o.getOrderDate().isBefore(LocalDate.of(2021, 03, 01)))
            .peek(o -> System.out.println(o.getOrderDate()))
            .flatMap(o -> o.getProducts().stream())
            .map(p -> p.getPrice())
            .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        
        
        // Task 9
        double task9 = orders.stream()
            .filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 03, 14)))
            .map(o -> o.getProducts().stream()
                .map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .mapToDouble(BigDecimal::doubleValue)
            .average()
            .orElse(0.0);

        // Task 10
        List<Product> task10products = products.stream().filter(p -> p.getCategory().equals("Книги")).toList();

        BigDecimal sum = task10products.stream()
            .map(Product::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        BigDecimal avg = sum.divide(BigDecimal.valueOf(task10products.size()));

        BigDecimal max = task10products.stream()
            .map(Product::getPrice)
            .max(BigDecimal::compareTo)
            .orElse(BigDecimal.ZERO);
        
        BigDecimal min = task10products.stream()
            .map(Product::getPrice)
            .min(BigDecimal::compareTo)
            .orElse(BigDecimal.ZERO);
        
        int count = task10products.size();

        // Task 11
        Map<Long, Integer> task11 = orders.stream()
            .collect(HashMap::new, (map, o) -> map.compute(o.getId(), (k, v) -> o.getProducts().size()), HashMap::putAll);
        
        // Task 12
        Map<Customer, List<Order>> task12 = customers.stream()
            .collect(Collectors.toMap(
                c -> c,
                c -> new ArrayList<>(c.getOrders())
            ));
        
        // Task 13
        Map<Order, Double> task13 = orders.stream()
            .collect(Collectors.toMap(
                c -> c,
                c -> c.getProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue()
            ));

        // Task 14
        Map<String, List<String>> task14 = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.getCategory(),
                Collectors.mapping(Product::getName, Collectors.toList())
            ));

        // Task 15
        Map<String, Product> task15 = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                        Optional::get
                )
            ));
    }
}
