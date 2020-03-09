package cn.eight.purchaseforward.service.serviceImpl;

import cn.eight.purchaseforward.dao.UserDao;
import cn.eight.purchaseforward.pojo.User;
import cn.eight.purchaseforward.service.UserService;
import cn.eight.purchaseforward.util.Tools;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    @Override
    public boolean registerUser(User user) {
        user.setPassword(new Tools().md5(user.getPassword()));
        return userDao.insterUser(user);
    }

    @Override
    public boolean checkUser(String username) {

        return userDao.queryUserByUsername(username);
    }

    @Override
    public boolean queryLoginUser(User user) {
        user.setPassword(Tools.md5(user.getPassword()));
        return userDao.queryLoginUser(user);
    }
}
