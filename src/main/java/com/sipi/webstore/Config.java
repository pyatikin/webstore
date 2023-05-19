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
        //String path = ("src/main/resources/food1.png");

        /*try {
            // Загрузка изображения из файла
            BufferedImage image = ImageIO.read(new File("C:\\Users\\pyatk\\IdeaProjects\\webstore\\src\\main\\resources\\static\\food1.png"));

            // Создание объекта ByteArrayOutputStream для записи данных изображения
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // Запись изображения в ByteArrayOutputStream в формате JPEG
            ImageIO.write(image, "png", baos);

            // Преобразование данных изображения в массив байтов
            byte[] imageBytes = baos.toByteArray();

            // Создание объекта BLOB из массива байтов
            Blob blob = new SerialBlob(imageBytes);

            // Использование объекта BLOB по вашему усмотрению (например, сохранение в базу данных)
            // ...

            // Закрытие потока ByteArrayOutputStream
            baos.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }*/

        File file1 = new File("C:\\Users\\pyatk\\IdeaProjects\\webstore\\src\\main\\resources\\static\\food1.png");
        byte [] bFile1 = new byte[(int) file1.length()];
        File file2 = new File("C:\\Users\\pyatk\\IdeaProjects\\webstore\\src\\main\\resources\\static\\food2.png");
        byte [] bFile2 = new byte[(int) file2.length()];
            try (FileInputStream fileInputStream = new FileInputStream(file1)) {
                fileInputStream.read(bFile1);
                fileInputStream.read(bFile2);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return args -> {
            orderRepository.save(new Orders(1,1,1,1,1,1,new Date(), "123"));
            productRepository.saveAll(List.of(new Product(1, Base64.getEncoder().encodeToString(bFile1), "Food1", "", 100),
                    new Product(2, Base64.getEncoder().encodeToString(bFile2), "Food2", "", 200)));
        };
    }
}
