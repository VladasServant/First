package com.example;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}