package com.zparkep.dao;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Qupu;

public interface QupuDao {

	int insertQupu(Qupu qupu)throws SQLException;

	List<Qupu> selectByTo_id(int to_id)throws SQLException;

	int deleteById(int id)throws SQLException;

}
