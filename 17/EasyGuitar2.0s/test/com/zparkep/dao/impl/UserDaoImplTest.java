package com.zparkep.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.zparkep.bean.User;
import com.zparkep.dao.UserDao;

public class UserDaoImplTest {

	@Test
	public void testInsertUser() throws SQLException {
		UserDao userDao = new UserDaoImpl();
		User user = new User("ss", "xiao", "sda", 16, "as", "as", "d", "fg", "sa", "asd");
		
		int res = userDao.insertUser(user);
		System.out.println(res);
	}

	@Test
	public void testUpdateUser() throws SQLException {
		UserDao userDao = new UserDaoImpl();
		User user = new User(20,"6", "6", "6", 16, "6", "6", "6", "6", "6", "6");
		
		int res = userDao.updateUser(user);
		System.out.println(res);
	}

	@Test
	public void testDeleteUser() throws SQLException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int deleteUser = userDaoImpl.deleteUser(5);
		System.out.println(deleteUser);
	}

	@Test
	public void testSelectAllUser() throws SQLException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> AllUser = userDaoImpl.selectAllUser();
		AllUser.forEach(System.out::println);
	}

	@Test
	public void testSelectById() throws SQLException {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User selectById = userDaoImpl.selectById(6);
		System.out.println(selectById);
	}

	

	@Test
	public void testSelectByCondition() throws SQLException {
	
	}

}
