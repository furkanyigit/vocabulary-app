package com.vocabularyapp.service;

import com.vocabularyapp.entitiy.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);
    List<User> getAll();
    void deleteById(Integer id);
    Boolean update (User User, Integer id);
}
