package com.zparkep.dao;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Teacher;
import com.zparkep.bean.User;

public interface TeacherDao {
	/**
	 * 添加老师
	 * @param teacher
	 * @return
	 * @throws SQLException
	 */
    int insertTeacher(Teacher teacher)throws SQLException;
    
    /**
     * 修改老师信息
     * @param teacher
     * @return
     * @throws SQLException
     */
    int updateTeacher(Teacher teacher)throws SQLException;
    
    /**
     * 根据id查找老师并进行删除
     */
    int deleteTeacher(Integer id)throws SQLException;
    
    /**
     * 查找全部老师
     * @return
     * @throws SQLException
     */
    List<Teacher> selectAllTeacher()throws SQLException;
    
    /**
     * 根据id查找老师
     * @param id
     * @return
     * @throws SQLException
     */
    Teacher selectById(Integer id)throws SQLException;
    
    
    /**
     * 条件查询
     * @param teacher
     * @return
     * @throws SQLException
     */
    List<Teacher> selectByCondition(Teacher teacher)throws SQLException;

}
