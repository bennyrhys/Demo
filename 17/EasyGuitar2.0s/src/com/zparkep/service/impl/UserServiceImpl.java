package com.zparkep.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.User;
import com.zparkep.dao.UserDao;
import com.zparkep.dao.impl.UserDaoImpl;
import com.zparkep.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String name, String pwd) throws SQLException {
		return userDao.selectByUsernameAndPassword(name, pwd);
	}

	@Override
	public User regist(User user) throws SQLException {
		int res =  userDao.insertUser(user);
		if(res == 1)
			return user;
		else
			return null;
	}

	@Override
	public int adduser(User user) throws SQLException {
		return userDao.insertUser(user);
	}

	@Override
	public List<User> selectAll() throws SQLException {
		return userDao.selectAllUser();
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return userDao.deleteUser(id);
	}

	@Override
	public User findById(int id) throws SQLException {
		return userDao.selectById(id);
	}

	@Override
	public int updateuser(User user) throws SQLException {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> selectByCondition(User user) throws SQLException {
		return userDao.selectByCondition(user);
	}

}
