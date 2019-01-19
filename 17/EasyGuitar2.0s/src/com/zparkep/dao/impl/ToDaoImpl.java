package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zparkep.bean.To;
import com.zparkep.dao.ToDao;
import com.zparkep.util.DBUtil;


public class ToDaoImpl implements ToDao {

	@Override
	public int insertTo(To to) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_to values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, to.getName());
		ps.setString(2, to.getUsername());
		ps.setString(3, to.getImg());
		ps.setString(4, to.getVideo());
		ps.setString(5, to.getSinger());
		ps.setString(6, to.getState());
		ps.setInt(7, to.getCnumber());
		ps.setInt(8, to.getLnumber());

		int res = ps.executeUpdate();

		DBUtil.free(null, ps, conn);

		return res;
	}

	@Override
	public int deleteToById(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_to where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		int res = ps.executeUpdate();

		DBUtil.free(null, ps, conn);

		return res;
	}

	@Override
	public int updateTo(To to) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_to set name=?,username=?,img=?,video=?,singer=?,state=?,cnumber=?,lnumber=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, to.getName());
		ps.setString(2, to.getUsername());
		ps.setString(3, to.getImg());
		ps.setString(4, to.getVideo());
		ps.setString(5, to.getSinger());
		ps.setString(6, to.getState());
		ps.setInt(7, to.getCnumber());
		ps.setInt(8, to.getLnumber());
		ps.setInt(9, to.getId());

		int res = ps.executeUpdate();

		DBUtil.free(null, ps, conn);

		return res;
	}

	@Override
	public To selectToById(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_to where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			String name = rs.getString("name");
			String username = rs.getString("username");
			String img = rs.getString("img");
			String video = rs.getString("video");
			String singer = rs.getString("singer");
			String state = rs.getString("state");
			int cnumber = rs.getInt("cnumber");
			int lnumber = rs.getInt("lnumber");

			return new To(id, name, username, img, video, singer, state, cnumber, lnumber);
		}
		DBUtil.free(rs, ps, conn);
		return null;
	}

	@Override
	public List<To> selectToAll() throws SQLException {
		List<To> res = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_to order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String username = rs.getString("username");
			String img = rs.getString("img");
			String video = rs.getString("video");
			String singer = rs.getString("singer");
			String state = rs.getString("state");
			int cnumber = rs.getInt("cnumber");
			int lnumber = rs.getInt("lnumber");

			To to = new To(id, name, username, img, video, singer, state, cnumber, lnumber);
			res.add(to);
		}
		DBUtil.free(rs, ps, conn);
		return res;
	}

	@Override
	public List<To> selectToByCondition(To to) throws SQLException {
		List<To> res = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select * from tb_to where 1=1 ");
		List<Object> args = new ArrayList<>();
		if(to.getName() != null && to.getName().trim().length() > 0){
			sql.append("and name like ?");
			args.add("%" + to.getName() + "%");
		}
		if(to.getUsername() != null && to.getUsername().trim().length() > 0){
			sql.append("and username like ?");
			args.add("%" + to.getUsername() + "%");
		}
		if(to.getSinger() != null && to.getSinger().trim().length() > 0){
			sql.append("and singer like ?");
			args.add("%" + to.getSinger() + "%");
		}
		if(to.getState() != null && to.getState().trim().length() > 0){
			sql.append("and state like ?");
			args.add("%" + to.getState() + "%");
		}
		if(to.getLowl() != null && to.getLowl() > 0){
			sql.append("and lnumber > ?");
			args.add(to.getLowl());
		}
		if(to.getName() != null && to.getName().trim().length() > 0){
			sql.append("and lnumber < ?");
			args.add(to.getHighl());
		}
		sql.append("order by id desc");
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		System.out.println(sql);

		for(int i = 0; i < args.size(); i++){
			ps.setObject(i+1, args.get(i));
		}
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String username = rs.getString("username");
			String img = rs.getString("img");
			String video = rs.getString("video");
			String singer = rs.getString("singer");
			String state = rs.getString("state");
			int cnumber = rs.getInt("cnumber");
			int lnumber = rs.getInt("lnumber");

			To t = new To(id, name, username, img, video, singer, state, cnumber, lnumber);
			res.add(t);
		}
		DBUtil.free(rs, ps, conn);
		return res;
	}

}
