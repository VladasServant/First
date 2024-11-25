package com.example;

public interface UserRepository {
    void createUser(User user);
    User getUserById(Long id);
    void updateUser(User user);
}
