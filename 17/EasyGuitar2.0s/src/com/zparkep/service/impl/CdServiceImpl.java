package com.zparkep.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Cdetails;
import com.zparkep.dao.CdDao;
import com.zparkep.dao.impl.CdDaoImpl;
import com.zparkep.service.CdService;

public class CdServiceImpl implements CdService {
	
	private CdDao cdDao = new CdDaoImpl();
	@Override
	public int add(Cdetails cd) throws SQLException {
		return cdDao.insertCd(cd);
	}
	@Override
	public List<Cdetails> selectByC_id(int c_id) throws SQLException {
		return cdDao.selectCdByC_id(c_id);
	}
	@Override
	public int deleteByC_id(int c_id) throws SQLException {
		return cdDao.deleteCdByC_id(c_id);
	}
	@Override
	public int deleteById(int id) throws SQLException {
		return cdDao.deleteCdById(id);
	}

}
