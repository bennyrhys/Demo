package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zparkep.bean.Opus;
import com.zparkep.dao.OpusDao;
import com.zparkep.util.DBUtil;

public class OpusDaoImpl implements OpusDao {

	@Override
	public int insertOpus(Opus opus) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_opus values(null,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, opus.getName());
		ps.setString(2, opus.getUsername());
		ps.setString(3, opus.getImg());
		ps.setString(4, opus.getVideo());
		ps.setString(5, opus.getState());
		ps.setString(6, opus.getQupustate());
		ps.setString(7, opus.getSinger());

		int res = ps.executeUpdate();

		DBUtil.free(null, ps, conn);

		return res;
	}

	@Override
	public int deleteOpusById(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tb_opus where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		int res = ps.executeUpdate();

		DBUtil.free(null, ps,conn);

		return res;
	}

	@Override
	public int updateOpus(Opus opus) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update tb_opus set name=?,username=?,img=?,video=?,state=?,qupustate=?,singer=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, opus.getName());
		ps.setString(2, opus.getUsername());
		ps.setString(3, opus.getImg());
		ps.setString(4, opus.getVideo());
		ps.setString(5, opus.getState());
		ps.setString(6, opus.getQupustate());
		ps.setString(7, opus.getSinger());
		ps.setInt(8, opus.getId());

		int res = ps.executeUpdate();

		DBUtil.free(null, ps, conn);

		return res;
	}

	@Override
	public Opus selectOpusById(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_opus where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			String name = rs.getString("name");
			String username = rs.getString("username");
			String img = rs.getString("img");
			String video = rs.getString("video");
			String state = rs.getString("state");
			String qupustate = rs.getString("qupustate");
			String singer = rs.getString("singer");

			return new Opus(id, name, username, img, video, state, qupustate, singer);
		}
		DBUtil.free(rs, ps,conn);
		return null;
	}

	@Override
	public List<Opus> selectOpusAll() throws SQLException {
		List<Opus> res = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tb_opus order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String username = rs.getString("username");
			String img = rs.getString("img");
			String video = rs.getString("video");
			String state = rs.getString("state");
			String qupustate = rs.getString("qupustate");
			String singer = rs.getString("singer");

			Opus opus = new Opus(id, name, username, img, video, state, qupustate, singer);
			res.add(opus);
		}
		DBUtil.free(rs, ps, conn);
		return res;
	}

	@Override
	public List<Opus> selectOpusByCondition(Opus opus) throws SQLException {
		List<Opus> res = new ArrayList<>();

		Connection conn = DBUtil.getConnection();
		StringBuffer sql = new StringBuffer("select * from tb_opus where 1=1 ");

		List<Object> args = new ArrayList<>();
		if(opus.getName() != null && opus.getName().trim().length() > 0){
			sql.append("and name like ?");
			args.add("%"+opus.getName()+"%");
		}
		if(opus.getUsername() != null && opus.getUsername().trim().length() > 0){
			sql.append("and username like ?");
			args.add("%"+opus.getUsername()+"%");
		}
		if(opus.getSinger() != null && opus.getSinger().trim().length() > 0){
			sql.append("and singer like ?");
			args.add("%"+opus.getSinger()+"%");
		}
		if(opus.getState() != null && opus.getState().trim().length() > 0){
			sql.append("and state like ?");
			args.add("%"+opus.getState()+"%");
		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());


		for(int i = 0; i < args.size(); i++) {
			ps.setObject(i+1, args.get(i));
		}

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String username = rs.getString("username");
			String img = rs.getString("img");
			String video = rs.getString("video");
			String state = rs.getString("state");
			String qupustate = rs.getString("qupustate");
			String singer = rs.getString("singer");

			Opus o = new Opus(id, name, username, img, video, state, qupustate, singer);
			res.add(o);
		}
		DBUtil.free(rs, ps,conn);
		return res;
	}
}
