package com.zparkep.service;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Teacher;

public interface TeacherService {
	/**
	 * 添加老师
	 * @param teacher
	 * @return
	 * @throws SQLException
	 */
	int addTeacher(Teacher teacher)throws SQLException;
	
	/**
	 * 查看所有老师
	 * @return
	 * @throws SQLException
	 */
    List<Teacher> selectAll()throws SQLException;
    
    /**
     * 根据id进行删除
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(Integer id)throws SQLException;
    
    /**
     * 更改老师信息
     * @param teacher
     * @return
     * @throws SQLException
     */
    int updateTeacher(Teacher teacher)throws SQLException;
    
    /**
     * 根据id进行查询 
     * @param id
     * @return
     * @throws SQLException
     */
    Teacher findById(Integer id)throws SQLException;
    
    /**
     * 条件查询
     * @param teacher
     * @return
     * @throws SQLException
     */
    List<Teacher> selectByCondition(Teacher teacher)throws SQLException;
}
