package com.sipi.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
