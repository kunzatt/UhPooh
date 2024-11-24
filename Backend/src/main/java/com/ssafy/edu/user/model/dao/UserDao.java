package com.ssafy.edu.user.model.dao;

import com.ssafy.edu.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    
    public List<User> userList();
    
    public User userLogin(User user);
    
    public int userSignup(User user);
    
    public int userUpdate(User user);
    
    public int userDelete(int userId);
    
    public User userDetail(int userId);
    
    public int userIdCheck(String userEmail);
    
    public int userNameCheck(String userName);
    
    public boolean checkPassword(User user);
    
    public int updatePassword(User user);
    
    public int updateLoginStatus(User user);
    
    public List<User> searchByEmail(Map<String, Object> params);
    
    public int getEmailSearchCount(Map<String, Object> params);
    
    public List<User> searchByName(Map<String, Object> params);
    
    public int getNameSearchCount(Map<String, Object> params);
    
    public List<User> searchByAdminStatus(Map<String, Object> params);
    
    public int getAdminSearchCount(Map<String, Object> params);
}
