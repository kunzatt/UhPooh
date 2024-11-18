package com.ssafy.edu.user.model.service;

import com.ssafy.edu.user.model.dto.User;
import com.ssafy.edu.user.model.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
    @Override
    public List<User> userList() {
        return userDao.userList();
    }
    
    @Override
    public User userLogin(User user) {
        return userDao.userLogin(user);
    }
    
    @Override
    public int userSignup(User user) {
        return userDao.userSignup(user);
    }
    
    @Override
    public int userUpdate(User user) {
        return userDao.userUpdate(user);
    }
    
    @Override
    public int userDelete(int userId) {
        return userDao.userDelete(userId);
    }
    
    @Override
    public User userDetail(int userId) {
        return userDao.userDetail(userId);
    }
    
    @Override
    public int userIdCheck(String userEmail) {
        return userDao.userIdCheck(userEmail);
    }
    
    @Override
    public int userNameCheck(String userName) {
        return userDao.userNameCheck(userName);
    }
    
    @Override
    public int updatePassword(User user) {
        return userDao.updatePassword(user);
    }
    
    @Override
    public int updateLoginStatus(User user) {
        return userDao.updateLoginStatus(user);
    }
}
