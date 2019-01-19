package com.zparkep.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.To;
import com.zparkep.dao.ToDao;
import com.zparkep.dao.impl.ToDaoImpl;
import com.zparkep.service.ToService;

public class ToServiceImpl implements ToService {

	private ToDao toDao = new ToDaoImpl();

	@Override
	public int addTo(To to) throws SQLException {
		return toDao.insertTo(to);
	}

	@Override
	public List<To> selectAll() throws SQLException {
		return toDao.selectToAll();
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return toDao.deleteToById(id);
	}

	@Override
	public To selectById(Integer id) throws SQLException {
		return toDao.selectToById(id);
	}

	@Override
	public int update(To to) throws SQLException {
		return toDao.updateTo(to);
	}

	@Override
	public List<To> selectByCondition(To to) throws SQLException {
		return toDao.selectToByCondition(to);
	}

}
