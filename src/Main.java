import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product(1L, "Tastiera Meccanica", "Elettronica", 119.99);
        Product p2 = new Product(2L, "ZEROCALCARE-Un polpo alla gola", "Libri", 18.99);
        Product p3 = new Product(3L, "Square Enix Miku Hatsune PVC Statue 1/7 Miku Hatsune Birthday 2021", "Figure", 299.99);
        Product p4 = new Product(4L, "Black Rock Shooter Empress Huke 1/7 Statue", "Figure", 99.99);
        Product p5 = new Product(5L, "groundWork of Evangelio Vol-1", "Libri", 59.99);
        Product p6 = new Product(6L, "Mouse Gaming", "Elettronica", 67.67);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.remove(p2);

        System.out.println(products.contains(p2));
        System.out.println(products.contains(p3));
        System.out.println(products.getLast());
        System.out.println(products.getFirst());
        System.out.println(products.get(3));
        System.out.println(products.get(4));


        Customer c1 = new Customer(1L, "Alberto Sivaletto", 1);
        Customer c2 = new Customer(2L, "Gianluca Depeffò", 2);
        Customer c3 = new Customer(3L, "Pietro Ubaldi", 3);
        Customer c4 = new Customer(4L, "Aldo Baglio", 1);
        Customer c5 = new Customer(5L, "Giovanni Storti", 2);
        Customer c6 = new Customer(6L, "Giacomo Poretti", 3);

        List<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);

        System.out.println(customers);

        Order o1 = new Order(1L, "consegnato",
                LocalDate.of(2026, 6, 12), LocalDate.of(2026, 6, 15),
                List.of(p1, p6), c1);

        Order o2 = new Order(2L, "consegnato",
                LocalDate.of(2026, 7, 2), LocalDate.of(2026, 7, 5),
                List.of(p3), c3);

        Order o3 = new Order(3L, "in elaborazione",
                LocalDate.of(2026, 7, 20), LocalDate.of(2026, 7, 28),
                List.of(p2, p5), c1);

        Order o4 = new Order(4L, "annullato",
                LocalDate.of(2026, 5, 30), LocalDate.of(2026, 6, 3),
                List.of(p4, p3, p6), c4);

        Order o5 = new Order(5L, "in elaborazione",
                LocalDate.of(2026, 7, 25), LocalDate.of(2026, 8, 1),
                List.of(p5), c2);

        List<Order> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);


        for (Product iProducts : products) {
            System.out.println(iProducts);
        }

        List<Product> libriCostosi = products.stream().filter(p -> p.getCategory().equals("Libri") && p.getPrice() > 30).toList();

        libriCostosi.forEach(System.out::println);

        List<Product> figureScontate = products.stream().filter(p -> p.getCategory().equals("Figure")).map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9)).toList();

    }
};
