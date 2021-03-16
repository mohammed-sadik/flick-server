package com.flick.app.services;

import com.flick.app.models.User;

import java.util.Map;

public interface UserService {
    Map<String, String> login(String userEmail, String password) throws Exception;

    Map<String, Boolean> register(User user) throws Exception;

    void validateToken(String token) throws Exception;
}
