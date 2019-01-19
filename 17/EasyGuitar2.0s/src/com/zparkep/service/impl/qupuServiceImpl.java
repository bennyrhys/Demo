package com.zparkep.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Qupu;
import com.zparkep.dao.QupuDao;
import com.zparkep.dao.impl.QupuDaoImpl;
import com.zparkep.service.QupuService;

public class qupuServiceImpl implements QupuService {

	private QupuDao qupuDao = new QupuDaoImpl();
	
	@Override
	public int add(Qupu qupu) throws SQLException {
		return qupuDao.insertQupu(qupu);
	}

	@Override
	public List<Qupu> selectByTo_id(int to_id) throws SQLException {
		return qupuDao.selectByTo_id(to_id);
	}

	@Override
	public int deleteById(int id) throws SQLException {
		return qupuDao.deleteById(id);
	}
	
}
