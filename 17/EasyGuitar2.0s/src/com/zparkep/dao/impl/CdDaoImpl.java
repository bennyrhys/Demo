package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zparkep.bean.Cdetails;
import com.zparkep.dao.CdDao;
import com.zparkep.util.DBUtil;

public class CdDaoImpl implements CdDao {

	@Override
	public int insertCd(Cdetails cd) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_cdetails(c_id, comment, date, username) values(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, cd.getC_id());
		ps.setString(2, cd.getComment());
		ps.setString(3, cd.getDate());
		ps.setString(4, cd.getUsername());
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public List<Cdetails> selectCdByC_id(int c_id) throws SQLException {
		List<Cdetails> res = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_cdetails where c_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, c_id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String comment = rs.getString("comment");
			String date = rs.getString("date");
			String username = rs.getString("username");
			Cdetails cdetails = new Cdetails(id,c_id, comment, date, username);
			res.add(cdetails);
		}
		DBUtil.free(rs, ps, conn);
		return res;
	}

	@Override
	public int deleteCdByC_id(int c_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_cdetails where c_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, c_id);
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public int deleteCdById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_cdetails where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		return res;
		
	}

}
