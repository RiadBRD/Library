package com.project.Library.service;

import java.util.List;

import com.project.Library.model.User;

public interface UserService {
    User createUser (User user);
    List<User> getAllUser();
}
