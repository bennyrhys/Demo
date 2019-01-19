package com.zparkep.service;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Opus;

public interface OpusService {
	int addOpus(Opus opus)throws SQLException;

	List<Opus> selectAll()throws SQLException;

	int deleteById(Integer id)throws SQLException;

	Opus selectById(Integer id)throws SQLException;

	int update(Opus opus)throws SQLException;

	List<Opus> selectByCondition(Opus opus)throws SQLException;

}
