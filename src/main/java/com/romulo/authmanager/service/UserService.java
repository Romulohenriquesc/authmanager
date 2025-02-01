package com.romulo.authmanager.service;

import com.romulo.authmanager.model.User;

public interface UserService {
    
    void save(User user);
    User findByUsername(String username);
}
