package com.zparkep.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Opus;
import com.zparkep.dao.OpusDao;
import com.zparkep.dao.impl.OpusDaoImpl;
import com.zparkep.service.OpusService;

public class OpusServiceImpl implements OpusService {
	private OpusDao opusDao = new OpusDaoImpl();

	@Override
	public int addOpus(Opus opus) throws SQLException {
		return opusDao.insertOpus(opus);
	}

	@Override
	public List<Opus> selectAll() throws SQLException {
		return opusDao.selectOpusAll();
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return opusDao.deleteOpusById(id);
	}

	@Override
	public Opus selectById(Integer id) throws SQLException {
		return opusDao.selectOpusById(id);
	}

	@Override
	public int update(Opus opus) throws SQLException {
		return opusDao.updateOpus(opus);
	}

	@Override
	public List<Opus> selectByCondition(Opus opus) throws SQLException {
		return opusDao.selectOpusByCondition(opus);
	}


}
