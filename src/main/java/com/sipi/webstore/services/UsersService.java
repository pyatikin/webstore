package com.sipi.webstore.services;

import com.sipi.webstore.models.Users;
import com.sipi.webstore.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/// \brief Класс для описаний прцоессов с пользователями в системе
/// Класс предназначен для описания взаимодействия с БД всего что связано с пользователем
///        и другими процессами которые могут влиять на сущность пользователя
@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository; ///Класс, который связывает модель пользователя и БД

    ///\brief Конструктор класса
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    ///\brief Метод поиска пользователя по почте
    public Users findUser(String login) {
        Optional<Users> foundUser = usersRepository.findUserByLogin(login);
        return foundUser.orElse(null);
    }

    ///\brief Метод сохранения пользоватедя в БД
    @Transactional
    public void save(Users users){
        usersRepository.save(users);
    }


}
