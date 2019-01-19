package com.zparkep.dao;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
    int insertUser(User user)throws SQLException;
    
    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws SQLException
     */
    int updateUser(User user)throws SQLException;
    
    /**
     * 根据id查找用户并进行删除
     */
    int deleteUser(Integer id)throws SQLException;
    
    /**
     * 查找全部用户
     * @return
     * @throws SQLException
     */
    List<User> selectAllUser()throws SQLException;
    
    /**
     * 根据id查找用户
     * @param id
     * @return
     * @throws SQLException
     */
    User selectById(Integer id)throws SQLException;
    
    /**
     * 判断用户是否已经注册
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    User selectByUsernameAndPassword(String username,String password)throws SQLException;
    
    /**
     * 条件查询
     * @param user
     * @return
     * @throws SQLException
     */
    List<User> selectByCondition(User user)throws SQLException;

    
}
