package cn.itwyf.service.impl;

import cn.itwyf.dao.UserRepository;
import cn.itwyf.pojo.User;
import cn.itwyf.service.UserService;
import cn.itwyf.utils.MD5Utils;
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
