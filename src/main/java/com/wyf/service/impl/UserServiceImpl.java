package com.wyf.service.impl;

import com.wyf.dao.UserRepository;
import com.wyf.pojo.User;
import com.wyf.service.UserService;
import com.wyf.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-04-28 16:05
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
