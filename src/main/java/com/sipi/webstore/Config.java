package com.sipi.webstore;


import com.sipi.webstore.models.Orders;
import com.sipi.webstore.models.Product;
import com.sipi.webstore.repositories.OrderRepository;
import com.sipi.webstore.repositories.ProductRepository;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Configuration
public class Config implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository, ProductRepository productRepository) {
        return args -> {
            Resource resource1 = resourceLoader.getResource("classpath:food1.png");
            InputStream inputStream1 = resource1.getInputStream();
            byte[] bFile1 = inputStreamToByteArray(inputStream1);

            /*Resource resource2 = resourceLoader.getResource("classpath:food2.png");
            InputStream inputStream2 = resource2.getInputStream();
            byte[] bFile2 = inputStreamToByteArray(inputStream2);*/

            orderRepository.save(new Orders(1, 1, 1, 1, 1, 1, new Date(), "123"));
            productRepository.saveAll(List.of(
                    new Product(1, Base64.getEncoder().encodeToString(bFile1), "Food1", "", 100)/*,
                    new Product(2, Base64.getEncoder().encodeToString(bFile2), "Food2", "", 200)*/
            ));
        };
    }

    private byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }
}
