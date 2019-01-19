package com.zparkep.service;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Cdetails;

public interface CdService {

	int add(Cdetails cd)throws SQLException;

	List<Cdetails> selectByC_id(int c_id)throws SQLException;

	int deleteByC_id(int c_id)throws SQLException;

	int deleteById(int id)throws SQLException;

}
