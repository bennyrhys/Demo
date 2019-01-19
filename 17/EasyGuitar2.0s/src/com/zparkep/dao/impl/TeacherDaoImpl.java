package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zparkep.bean.Teacher;
import com.zparkep.bean.User;
import com.zparkep.dao.TeacherDao;
import com.zparkep.util.DBUtil;

import jdk.nashorn.internal.objects.annotations.Where;



public class TeacherDaoImpl implements TeacherDao{

	@Override
	public int insertTeacher(Teacher teacher) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_teacher values(null,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teacher.getName());
		ps.setString(2, teacher.getImg());
		
		int res = ps.executeUpdate();
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public int updateTeacher(Teacher teacher) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_teacher set name=?, img = ? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teacher.getName());
		ps.setString(2, teacher.getImg());
		ps.setInt(3, teacher.getId());
		
		int res = ps.executeUpdate();
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public int deleteTeacher(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_teacher where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int res = ps.executeUpdate();
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public List<Teacher> selectAllTeacher() throws SQLException {
		List<Teacher> list = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_teacher order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String img = rs.getString("img");
			Teacher teacher = new Teacher(id, name, img);
			list.add(teacher);
		}
		DBUtil.free(rs, ps, conn);
		return list;
	}

	@Override
	public Teacher selectById(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_teacher where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			String name = rs.getString("name");
			String img = rs.getString("img");
			return new Teacher(id, name, img);
		}
		DBUtil.free(rs, ps, conn);
		return null;
	}

	
	@Override
	public List<Teacher> selectByCondition(Teacher teacher) throws SQLException {
        ArrayList<Teacher> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        StringBuffer sql = new StringBuffer("select * from tb_teacher where 1=1 ");
        ArrayList<Object> args = new ArrayList<>();
        
        if(teacher.getId()!=null&&teacher.getId()>0) {
        	sql.append("and id = ? ");
        	args.add(teacher.getId());
        }
        if(teacher.getName()!=null&&teacher.getName().trim().length()>0) {
        	sql.append("and name = ? ");
        	args.add(teacher.getName());
        }
       
		
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql.toString());
        
        for(int i = 0; i < args.size();i++) {
        	ps.setObject(i+1, args.get(i));
        }
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	String img = rs.getString("img");
        	teacher = new Teacher(id, name, img);
        	list.add(teacher);
        }
        DBUtil.free(rs, ps, conn);
        return list;
	}
	

}
