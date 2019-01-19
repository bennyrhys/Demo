package com.zparkep.dao;

import java.sql.SQLException;

import com.zparkep.bean.Administrator;

public interface AdmiDao {
	/**
     * 管理员登录
     * @param houname
     * @param houpwd
     * @return
     * @throws SQLException 
     */
	Administrator selectByhounameAndhoupwd(String houname, String houpwd) throws SQLException;

}
