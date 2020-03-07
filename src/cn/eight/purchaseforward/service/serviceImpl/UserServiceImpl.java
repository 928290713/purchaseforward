package cn.eight.purchaseforward.service.serviceImpl;

import cn.eight.purchaseforward.dao.UserDao;
import cn.eight.purchaseforward.pojo.User;
import cn.eight.purchaseforward.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();
    @Override
    public boolean checkUser(User user) {
        return userDao.queryUser(user);
    }
}
