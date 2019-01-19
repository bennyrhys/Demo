package com.zparkep.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Teacher;
import com.zparkep.dao.TeacherDao;
import com.zparkep.dao.impl.TeacherDaoImpl;
import com.zparkep.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	private TeacherDao teacherDao = new TeacherDaoImpl();  
	
	@Override
	public int addTeacher(Teacher teacher) throws SQLException {
		return teacherDao.insertTeacher(teacher);
	}

	@Override
	public List<Teacher> selectAll() throws SQLException {
		return teacherDao.selectAllTeacher();
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return teacherDao.deleteTeacher(id);
	}

	@Override
	public int updateTeacher(Teacher teacher) throws SQLException {
		return teacherDao.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> selectByCondition(Teacher teacher) throws SQLException {
		return teacherDao.selectByCondition(teacher);
	}

	@Override
	public Teacher findById(Integer id) throws SQLException {
	
		return teacherDao.selectById(id);
	}

}
