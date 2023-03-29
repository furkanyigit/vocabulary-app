package com.vocabularyapp.service;

import com.vocabularyapp.entitiy.User;
import com.vocabularyapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean update(User user, Integer id) {
        User dbUser = userRepository.findById(id).orElse(null);
        if(dbUser != null){
         dbUser.setFirstname(user.getFirstname());
         dbUser.setLastname(user.getLastname());
         dbUser.setEmail(user.getEmail());
         dbUser.setPassword(user.getPassword());
         userRepository.save(dbUser);
         return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
}
