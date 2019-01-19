package com.zparkep.service.impl;

import java.sql.SQLException;

import com.zparkep.bean.Administrator;
import com.zparkep.dao.AdmiDao;
import com.zparkep.dao.impl.AdminiDaoImpl;
import com.zparkep.service.AdmiService;

public class AdminiServiceImpl implements AdmiService{
	private AdmiDao admiDao = new AdminiDaoImpl();
	@Override
	public Administrator houlogin(String houname, String password) throws SQLException {
		
		return admiDao.selectByhounameAndhoupwd(houname, password);
	}

}
