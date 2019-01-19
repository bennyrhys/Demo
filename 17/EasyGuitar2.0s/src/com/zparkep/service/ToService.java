package com.zparkep.service;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.To;

public interface ToService {
	int addTo(To to)throws SQLException;

	List<To> selectAll()throws SQLException;

	int deleteById(Integer id)throws SQLException;

	To selectById(Integer id)throws SQLException;

	int update(To to)throws SQLException;

	List<To> selectByCondition(To to)throws SQLException;

}
