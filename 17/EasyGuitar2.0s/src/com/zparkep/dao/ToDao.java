package com.zparkep.dao;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.To;

public interface ToDao {

	int insertTo(To to) throws SQLException;


	int deleteToById(Integer id) throws SQLException;


	int updateTo(To to) throws SQLException;


	To selectToById(Integer id) throws SQLException;


	List<To> selectToAll() throws SQLException;

	List<To> selectToByCondition(To to) throws SQLException;

}
