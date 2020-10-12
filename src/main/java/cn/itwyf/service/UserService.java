package cn.itwyf.service;

import cn.itwyf.pojo.User;

public interface UserService {
    User checkUser(String username, String password);
}
