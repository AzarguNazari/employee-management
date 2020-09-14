package com.dashboard.service;

import com.dashboard.exception.UserNotFoundException;
import com.dashboard.model.User;
import com.dashboard.repository.UserRepository;
import com.dashboard.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer userId) {
        final Optional<User> byId = userRepository.findById(userId);
        if(!byId.isPresent()) throw new UserNotFoundException();
        userRepository.deleteById(userId);
    }

    @Override
    public void update(Integer userId, User user) {
        final Optional<User> byId = userRepository.findById(userId);
        if(!byId.isPresent()) throw new UserNotFoundException();
        user.setId(userId);
        userRepository.deleteById(userId);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        final Optional<User> byId = userRepository.findById(userId);
        if(!byId.isPresent()) throw new UserNotFoundException();
        return byId.get();
    }
}
