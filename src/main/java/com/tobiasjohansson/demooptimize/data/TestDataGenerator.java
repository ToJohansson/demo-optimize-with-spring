package com.tobiasjohansson.demooptimize.data;

import com.tobiasjohansson.demooptimize.models.Order;
import com.tobiasjohansson.demooptimize.models.Product;
import com.tobiasjohansson.demooptimize.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class TestDataGenerator implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        generateTestData();
    }

    private void generateTestData() {
        System.out.println("Initilizing test data");
        System.out.println("Please standby");


        int testOrderar = 10000;
        Random random = new Random();
        for (int i = 0; i < testOrderar; i++) { // Skapa 10 ordrar som testdata
            Order order = new Order();
            order.setOrderDate(new Date());

            int productCount = random.nextInt(7) + 1; // Slumpmässigt antal produkter mellan 1-7
            List<Product> products = new ArrayList<>();
            for (int j = 0; j < productCount; j++) {
                Product product = createRandomProduct();
                products.add(product);
            }

            order.setProductList(products);
            order.setTotalPrice(calculateTotalPrice(products));
            System.out.println("..." + i);

            orderService.saveOrder(order);
        }
        System.out.println("Test data is complete...");

    }

    private String generateRandomName(int length) {
        Random random = new Random();
        StringBuilder nameBuilder = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            nameBuilder.append(randomChar);
        }
        return nameBuilder.toString();
    }

    private Product createRandomProduct() {
        Random random = new Random();
        Product product = new Product();

        // Slumpmässigt namn med tecken
        int nameLength = random.nextInt(40) + 5; // Slumpmässigt namnlängd mellan 5 och 14 tecken
        String randomName = generateRandomName(nameLength);

        product.setName(randomName);
        product.setPrice(random.nextInt(1000)); // Slumpmässigt pris

        return product;
    }

    private long calculateTotalPrice(List<Product> products) {
        long totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
