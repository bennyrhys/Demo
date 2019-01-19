package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zparkep.dao.CoDao;
import com.zparkep.util.DBUtil;

public class CoDaoImpl implements CoDao {

	@Override
	public int insertCoToOpus(Integer user_id, int opus_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_comment(user_id, opus_id) values(?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, user_id);
		ps.setInt(2, opus_id);
		
		ps.executeUpdate();
		
		String sql2 = "select * from tb_comment where user_id = ? and opus_id = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		ps2.setInt(1, user_id);
		ps2.setInt(2, opus_id);
		
		ResultSet rs = ps2.executeQuery();
		if(rs.next()) {
			return rs.getInt("id");
		}
		if(ps != null) {
			ps.close();
		}
		DBUtil.free(rs, ps2, conn);
		return 0;
	}

	@Override
	public int sellectCoByOpus_id(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_comment where opus_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt("id");
		}
		if(ps != null) {
			ps.close();
		}
		DBUtil.free(rs, ps, conn);
		return 0;
	}

	@Override
	public int sellectCoByTopus_id(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_comment where topus_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt("id");
		}
		if(ps != null) {
			ps.close();
		}
		DBUtil.free(rs, ps, conn);
		return 0;
	}

	@Override
	public int insertCoToTopus(Integer user_id, int to_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_comment(user_id, topus_id) values(?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, user_id);
		ps.setInt(2, to_id);
		
		ps.executeUpdate();
		
		String sql2 = "select * from tb_comment where user_id = ? and topus_id = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		ps2.setInt(1, user_id);
		ps2.setInt(2, to_id);
		
		ResultSet rs = ps2.executeQuery();
		if(rs.next()) {
			return rs.getInt("id");
		}
		if(ps != null) {
			ps.close();
		}
		DBUtil.free(rs, ps2, conn);
		return 0;
	}

	@Override
	public int deleteCoByOpus_id(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_comment where opus_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public int deleteCoByTo_id(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_comment where topus_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		return res;
	}

}
