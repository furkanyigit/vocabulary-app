package com.vocabularyapp.service;

import com.vocabularyapp.entitiy.User;
import com.vocabularyapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Boolean login(User user) {
        User dbUser = userRepository.findUserByEmail(user.getEmail());
        if(user.getEmail() == dbUser.getEmail() && user.getPassword() == dbUser.getPassword()){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteById(Long id) {
        if(userRepository.findById(id) != null) {
            userRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean update(User user, Long id) {
        User dbUser = userRepository.findById(id).orElse(null);
        if(dbUser != null){
            dbUser.setFirstname(user.getFirstname());
            dbUser.setLastname(user.getLastname());
            dbUser.setEmail(user.getEmail());
            dbUser.setPassword(user.getPassword());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
