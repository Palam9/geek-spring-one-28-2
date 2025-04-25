package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;
import ru.geekbrains.persist.UserRepositoryImpl;

import java.util.Scanner;


/*1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository,
в виде List<Product>, при старте в него нужно добавить 5 любых товаров.
2. ProductRepository позволяет получить весь список или один товар по id.
Создаем бин Cart, в который можно добавлять и удалять товары по id.
3. Написать консольное приложение, позволяющее управлять корзиной.
4. При каждом запросе корзины из контекста, должна создаваться новая корзина.*/


public class Main {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userService", UserService.class);

        CartService cartService = context.getBean("cartService", CartService.class);
        cartService = context.getBean("cartService", CartService.class);
        cartService = context.getBean("cartService", CartService.class);

        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.print("Enter user name: ");
            String name = sc.nextLine();

            System.out.print("Enter user role: ");
            String role = sc.nextLine();

            try {
                userService.insert(new User(name, role));
            } catch (IllegalArgumentException ex) {
                System.out.println("Incorrect role name");
            }

            System.out.println("New user added. Now " + userService.getCount() + " users in repository");
        }
    }
}
