package com.sipi.webstore;

import com.sipi.webstore.models.Orders;
import com.sipi.webstore.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        return args -> {
            orderRepository.save(new Orders(1,1,1,1,1,1,new Date(), "123"));
        };
    }
}
