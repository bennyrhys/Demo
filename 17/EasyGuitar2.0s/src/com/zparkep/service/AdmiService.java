package com.zparkep.service;

import java.sql.SQLException;

import com.zparkep.bean.Administrator;

public interface AdmiService {
	/**
	 * 管理员登录功能
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	Administrator houlogin(String houname,String password)throws SQLException;

}
