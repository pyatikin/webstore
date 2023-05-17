package com.sipi.webstore.controllers;

import com.sipi.webstore.models.Users;
import com.sipi.webstore.services.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


///\brief Контрооллер для обработки обращений для входа в систему
/// Контроллер для обработки данных пользователей входящих в систему
@Controller
@RequestMapping("/")
public class Login {

    ///\brief Стартовая страница
    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    private final UsersService usersService; ///Класс, который связывает модель пользователя и БД

    ///\brief Конструктор класса
    public Login(UsersService usersService) {
        this.usersService = usersService;
    }

    ///\brief Метод для возврата данных для страницы логина
    @GetMapping("login")
    public String login()
    {
        return "login";
    }
    ///\brief Метод для возврата данных для страницы регистрации
    @GetMapping("registration")
    public String registration(){
        return "registration";
    }
    ///\brief Метод для проверки логина пользователя
    @PostMapping("login")
    public String checkLogin(@RequestParam("email") String email, HttpServletRequest httpServletRequest) {
        Users users;
        if ((users = usersService.findUser(email)) != null){
            if(httpServletRequest.getParameter("password").equals(users.getPassword()))
                System.out.println("TRUE!!!!!");
            else
                System.out.println("FALSE!!!!!");
            return "redirect:/";
        }
        System.out.println("checking...");
        return "login";
    }
    /// \brief Метод для проверки новогго зарегестрированного пользователя
    /*@PostMapping("registration")
    public void checkRegistration(HttpServletRequest httpServletRequest){
        //Map<String, String[]> attributes = httpServletRequest.getParameterMap();
        //System.out.println(attributes.get("name"). + attributes.get("mail")[0] + attributes.get("phone")[0] + attributes.get("password")[0]);
        Users users = new Users(0, httpServletRequest.getParameter("name"), httpServletRequest.getParameter("email"), httpServletRequest.getParameter("phone"), httpServletRequest.getParameter("password"));
        usersService.save(users);
        System.out.println("adding...");
    }*/
}
