package com.vtb.kortunov.lesson21;

import com.vtb.kortunov.lesson21.entities.Product;
import com.vtb.kortunov.lesson21.entities.User;
import com.vtb.kortunov.lesson21.repositories.ProductRepository;
import com.vtb.kortunov.lesson21.repositories.UserRepository;
import com.vtb.kortunov.lesson21.services.ProductService;
import com.vtb.kortunov.lesson21.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        List<Product> products = context.getBean(ProductService.class).getProducts();
        List<User> users = context.getBean(UserService.class).getUsers();
        for (Product p : products) {
            System.out.println(p);
        }
        for (User u : users) {
            System.out.println(u);
        }
        context.close();

    }
}
