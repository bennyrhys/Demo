package com.zparkep.service;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.User;

public interface UserService {
	/**
	 * 用户登录功能
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	User login(String name, String pwd) throws SQLException;
	
	/**
	 * 注册功能
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	User regist(User user) throws SQLException;

	/**
	 * 添加用户功能
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int adduser(User user)throws SQLException;

	/**
	 * 查找所有用户
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAll()throws SQLException;

	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteById(int id)throws SQLException;

	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	User findById(int id)throws SQLException;

	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int updateuser(User user)throws SQLException;

	/**
	 * 按条件查找用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	List<User> selectByCondition(User user)throws SQLException;

}
