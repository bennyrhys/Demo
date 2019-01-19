package com.zparkep.service.impl;

import java.sql.SQLException;

import com.zparkep.dao.CoDao;
import com.zparkep.dao.impl.CoDaoImpl;
import com.zparkep.service.CoService;

public class CoServiceImpl implements CoService {
	private CoDao coDao = new CoDaoImpl();
	@Override
	public int addToOpus(Integer user_id, int opus_id) throws SQLException {
		return coDao.insertCoToOpus(user_id, opus_id);
	}
	@Override
	public int selectByOpus_id(Integer id) throws SQLException {
		return coDao.sellectCoByOpus_id(id);
	}
	@Override
	public int selectByTopus_id(Integer id) throws SQLException {
		return coDao.sellectCoByTopus_id(id);
	}
	@Override
	public int addToTopus(Integer user_id, int to_id) throws SQLException {
		return coDao.insertCoToTopus(user_id, to_id);
	}
	@Override
	public int deleteByOpus_id(int id) throws SQLException {
		return coDao.deleteCoByOpus_id(id);
	}
	@Override
	public int deleteByTo_id(Integer id) throws SQLException {
		return coDao.deleteCoByTo_id(id);
	}

}
