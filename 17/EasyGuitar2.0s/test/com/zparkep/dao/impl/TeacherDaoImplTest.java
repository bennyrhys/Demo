package com.zparkep.dao.impl;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zparkep.bean.Teacher;

public class TeacherDaoImplTest {

	@Test
	public void testInsertUser() throws SQLException {
        TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
        Teacher teacher = new Teacher("ss", "a");
        int res = teacherDaoImpl.insertTeacher(teacher);
        System.out.println(res);
	}

	@Test
	public void testUpdateUser() throws SQLException {
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
        Teacher teacher = new Teacher(1,"sss", "a");
        int res = teacherDaoImpl.updateTeacher(teacher);
        System.out.println(res);
	}

	@Test
	public void testDeleteUser() throws SQLException {
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
       
        int res = teacherDaoImpl.deleteTeacher(1);
        System.out.println(res);
	}

	@Test
	public void testSelectAllTeacher() throws SQLException {
        TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
        List<Teacher> list = teacherDaoImpl.selectAllTeacher();
        list.forEach(System.out::println);
	}

	@Test
	public void testSelectById() throws SQLException {
		TeacherDaoImpl impl = new TeacherDaoImpl();
		Teacher selectById = impl.selectById(2);
		System.out.println(selectById);
	}

	

	@Test
	public void testSelectByCondition() {
		fail("Not yet implemented");
	}

}
