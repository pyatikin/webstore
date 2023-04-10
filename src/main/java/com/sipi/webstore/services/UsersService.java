package com.sipi.webstore.services;

import com.sipi.webstore.models.User;
import com.sipi.webstore.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User findUser(String mail) {
        Optional<User> foundUser = usersRepository.findUserByMail(mail);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user){
        usersRepository.save(user);
    }


}
