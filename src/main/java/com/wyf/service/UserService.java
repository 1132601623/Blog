package com.wyf.service;

import com.wyf.pojo.User;

public interface UserService {
    User checkUser(String username, String password);
}
