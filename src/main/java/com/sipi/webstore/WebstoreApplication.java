package com.sipi.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@mainpage  Добро пожаловать в документацию GreenFood!
 *В этой документации вы найдете информацию о том, как пользоваться нашим сервисом.\n
 *Наши API-интерфейсы и примеры кода помогут вам быстро начать работу с нашим сервисом.
 */

///\brief Класс предназначенный для настройки конфигурации и запуска приложения
@SpringBootApplication
public class WebstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebstoreApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Замените "ваш_домен" на домен вашего веб-приложения
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
