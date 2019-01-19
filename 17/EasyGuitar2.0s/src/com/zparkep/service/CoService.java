package com.zparkep.service;

import java.sql.SQLException;

public interface CoService {

	int addToOpus(Integer user_id, int opus_id)throws SQLException;

	int selectByOpus_id(Integer id)throws SQLException;

	int selectByTopus_id(Integer id)throws SQLException;

	int addToTopus(Integer user_id, int to_id)throws SQLException;

	int deleteByOpus_id(int id)throws SQLException;

	int deleteByTo_id(Integer id)throws SQLException;

}
