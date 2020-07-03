package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public StartupData(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
    	 exampleProducts();
    	 userAccount();
    }

    private void userAccount(){
        User user = new User();
        User user1 = new User();
        user.setPassword("user");
        user.setName("Anupesh");
        user.setEmail("user@example.com");
        userService.save(user);
        user1.setPassword("user1");
        user1.setName("Anupesh1");
        user1.setEmail("user1@example.com");
        userService.save(user1);
    }


    private void exampleProducts(){
        final String NAME = "Example Name";
        final String DESCRIPTION = "Example Description";
        final BigDecimal PRICE = BigDecimal.valueOf(22);
        final int quantity = 2;

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        
        product1.setName(NAME);
        product1.setDescription(DESCRIPTION);
        product1.setPrice(PRICE);
        product1.setAvailability(true);

        product2.setName(NAME);
        product2.setDescription(DESCRIPTION);
        product2.setPrice(PRICE);
        product2.setAvailability(false);
        
        product3.setName("Samsung");
        product3.setDescription("Galaxy S10");
        product3.setPrice(BigDecimal.valueOf(70000));
        product3.setAvailability(true);
        
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
    }
}
