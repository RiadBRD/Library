package com.project.Library.service;

import org.springframework.stereotype.Service;

import com.project.Library.exceptions.InvalidUserException;
import com.project.Library.model.User;
import com.project.Library.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if(user.getFirstname().isBlank() || user.getLastname().isBlank()){
            throw new InvalidUserException("Il manque le prenom ou nom de famille");
        }

        return userRepository.save(user);
        
    }

}
