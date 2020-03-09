package cn.eight.purchaseforward.service;

import cn.eight.purchaseforward.pojo.User;

public interface UserService {
    boolean registerUser(User user);
    boolean checkUser(String name);
    boolean queryLoginUser(User user);
}
