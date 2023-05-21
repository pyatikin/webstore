package com.sipi.webstore;

import com.sipi.webstore.models.Orders;
import com.sipi.webstore.models.Product;
import com.sipi.webstore.repositories.OrderRepository;
import com.sipi.webstore.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository, ProductRepository productRepository) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource("food1.png").getFile());
        byte[] bFile1 = new byte[(int) file1.length()];
        /*File file2 = new File(classLoader.getResource("food2.png").getFile());
        byte[] bFile2 = new byte[(int) file2.length()];*/
        try (FileInputStream fileInputStream1 = new FileInputStream(file1)/*;
             FileInputStream fileInputStream2 = new FileInputStream(file2)*/) {
            fileInputStream1.read(bFile1);
            /*fileInputStream2.read(bFile2);*/
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return args -> {
            orderRepository.save(new Orders(1, 1, 1, 1, 1, 1, new Date(), "123"));
            productRepository.saveAll(List.of(
                    new Product(1, Base64.getEncoder().encodeToString(bFile1), "Food1", "", 100)/*,
                    new Product(2, Base64.getEncoder().encodeToString(bFile2), "Food2", "", 200)*/
            ));
        };
    }
}
