package com.zparkep.dao;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Cdetails;

public interface CdDao {

	int insertCd(Cdetails cd)throws SQLException;

	List<Cdetails> selectCdByC_id(int c_id)throws SQLException;

	int deleteCdByC_id(int c_id)throws SQLException;

	int deleteCdById(int id)throws SQLException;

}
