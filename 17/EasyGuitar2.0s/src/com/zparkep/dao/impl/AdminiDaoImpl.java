package com.zparkep.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zparkep.bean.Administrator;
import com.zparkep.dao.AdmiDao;
import com.zparkep.util.DBUtil;

public class AdminiDaoImpl implements AdmiDao{

	@Override
	public Administrator selectByhounameAndhoupwd(String username, String password) throws SQLException {
		Connection conn = DBUtil.getConnection();
        String sql = "select * from tb_administrator where username=? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
        	 Administrator administrator = new Administrator(username, password);
        	 return administrator;
        }
       
        DBUtil.free(rs, ps, conn);
		return null;
	}
	

}
