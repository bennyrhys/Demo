package com.zparkep.dao;

import java.sql.SQLException;

public interface CoDao {

	int insertCoToOpus(Integer user_id, int opus_id)throws SQLException;

	int sellectCoByOpus_id(Integer id)throws SQLException;

	int sellectCoByTopus_id(Integer id)throws SQLException;

	int insertCoToTopus(Integer user_id, int to_id)throws SQLException;

	int deleteCoByOpus_id(int id)throws SQLException;

	int deleteCoByTo_id(Integer id)throws SQLException;

}
