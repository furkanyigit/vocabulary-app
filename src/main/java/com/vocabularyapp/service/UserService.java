package com.vocabularyapp.service;

import com.vocabularyapp.entitiy.User;

import java.util.List;

public interface UserService {

    User save(User user);
    Boolean login(User user);
    User getById(Long id);
    List<User> getAll();
    Boolean deleteById(Long id);
    Boolean update(User user, Long id);
}
