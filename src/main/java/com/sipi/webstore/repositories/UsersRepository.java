package com.sipi.webstore.repositories;

import com.sipi.webstore.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/// \brief Класс для использовавния функций JPA
/// Класс позволяет указать Spring JPA какой класс, каким образом связывать с БД
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    /// Метод для поиска пользователя по почте
    Optional<Users> findUserByLogin(String login);
}
