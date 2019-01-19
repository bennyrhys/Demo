package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zparkep.bean.Administrator;
import com.zparkep.bean.User;
import com.zparkep.dao.UserDao;
import com.zparkep.util.DBUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public int insertUser(User user) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into tb_user values(null,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getNickname());
        ps.setString(3, user.getPassword());
        ps.setInt(4, user.getAge());
        ps.setString(5, user.getGender());
        ps.setString(6, user.getMail());
        ps.setString(7, user.getImg());
        ps.setString(8, user.getIntro());
        ps.setString(9, user.getAddr());
        ps.setString(10, user.getWeibo());
		
        int res = ps.executeUpdate();
        
        DBUtil.free(null, ps, conn);
        return res;
	}

	@Override
	public int updateUser(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
        String sql = "update tb_user set username=?, nickname=?, password=?, age=?, gender=?, mail=?, img=?, intro=?, addr=?, weibo=? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getNickname());
        ps.setString(3, user.getPassword());
        ps.setInt(4, user.getAge());
        ps.setString(5, user.getGender());
        ps.setString(6, user.getMail());
        ps.setString(7, user.getImg());
        ps.setString(8, user.getIntro());
        ps.setString(9, user.getAddr());
        ps.setString(10, user.getWeibo());
		ps.setInt(11, user.getId());
        
        int res = ps.executeUpdate();
        
        DBUtil.free(null, ps, conn);
        return res;
		
	}

	@Override
	public int deleteUser(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_user where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public List<User> selectAllUser() throws SQLException {
        List<User> allList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_user order by id desc";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        	int id = rs.getInt("id");
        	String username = rs.getString("username");
        	String nickname = rs.getString("nickname");
        	String password = rs.getString("password");
        	int age = rs.getInt("age");
        	String gender = rs.getString("gender");
        	String mail = rs.getString("mail");
        	String img = rs.getString("img");
        	String intro = rs.getString("intro");
        	String addr = rs.getString("addr");
        	String weibo = rs.getString("weibo");
        	User user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);
        	allList.add(user);
        }
        DBUtil.free(rs, ps, conn);
		return allList;
	}

	@Override
	public User selectById(Integer id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_user where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	String nickname = rs.getString("nickname");
        	String username = rs.getString("username");
        	String password = rs.getString("password");
        	int age = rs.getInt("age");
        	String gender = rs.getString("gender");
        	String mail = rs.getString("mail");
        	String img = rs.getString("img");
        	String intro = rs.getString("intro");
        	String addr = rs.getString("addr");
        	String weibo = rs.getString("weibo");
        	User user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);
        	return user;
        }
        DBUtil.free(rs, ps, conn);
		return null;
	}

	@Override
	public User selectByUsernameAndPassword(String username, String password) throws SQLException {
		Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_user where username=? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	int id = rs.getInt("id");
        	String nickname = rs.getString("nickname");
        	int age = rs.getInt("age");
        	String gender = rs.getString("gender");
        	String mail = rs.getString("mail");
        	String img = rs.getString("img");
        	String intro = rs.getString("intro");
        	String addr = rs.getString("addr");
        	String weibo = rs.getString("weibo");
        	User user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);
        	return user;
        }
        DBUtil.free(rs, ps, conn);
		return null;
	}

	@Override
	public List<User> selectByCondition(User user) throws SQLException {
		List<User> res = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select * from tb_user where 1=1 ");
		
		List<Object> args = new ArrayList<>();  
		
		if(user.getUsername() != null && user.getUsername().trim().length()>0) {
			sql.append("and username = ? ");
			args.add(user.getUsername());
		}
		if(user.getNickname() != null && user.getNickname().trim().length()>0) {
			sql.append("and nickname = ? ");
			args.add(user.getNickname());
		}
		if(user.getLowage() != null && user.getLowage()>0) {
			sql.append("and age >= ? ");
			args.add(user.getLowage());
		}
		if(user.getHighage() != null && user.getHighage()>0) {
			sql.append("and age <= ? ");
			args.add(user.getHighage());
		}
		if(user.getGender() != null && user.getGender().trim().length()>0) {
			sql.append("and gender = ? ");
			args.add(user.getGender());
		}
		if(user.getIntro() != null && user.getIntro().trim().length()>0) {
			sql.append("and intro like ? ");
			args.add(user.getIntro());
		}
		if(user.getAddr() != null && user.getAddr().trim().length()>0) {
			sql.append("and addr = ? ");
			args.add(user.getAddr());
		}
		
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());

		for(int i =0;i<args.size();i++) {
			ps.setObject(i+1, args.get(i));
		}
		
		ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	        	int id = rs.getInt("id");
	        	String username = rs.getString("username");
	        	String nickname = rs.getString("nickname");
	        	String password = rs.getString("password");
	        	int age = rs.getInt("age");
	        	String gender = rs.getString("gender");
	        	String mail = rs.getString("mail");
	        	String img = rs.getString("img");
	        	String intro = rs.getString("intro");
	        	String addr = rs.getString("addr");
	        	String weibo = rs.getString("weibo");
	        	user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);
	        	res.add(user);
	        }
	        DBUtil.free(rs, ps, conn);
			return res;
	
	}

	

}
