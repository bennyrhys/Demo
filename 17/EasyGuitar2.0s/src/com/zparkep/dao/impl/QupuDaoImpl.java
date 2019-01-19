package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zparkep.bean.Qupu;
import com.zparkep.dao.QupuDao;
import com.zparkep.util.DBUtil;

public class QupuDaoImpl implements QupuDao {

	@Override
	public int insertQupu(Qupu qupu) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_qupu(to_id, img) values(?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, qupu.getTo_id());
		ps.setString(2, qupu.getImg());
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		return res;
	}

	@Override
	public List<Qupu> selectByTo_id(int to_id) throws SQLException {
		List<Qupu> res = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_qupu where to_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, to_id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String img = rs.getString("img");
			
			Qupu qupu = new Qupu(id, to_id, img);
			res.add(qupu);
		}
		
		DBUtil.free(rs, ps, conn);
		return res;
	}

	@Override
	public int deleteById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_qupu where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		int res = ps.executeUpdate();
		
		DBUtil.free(null, ps, conn);
		
		return res;
	}
	
}
