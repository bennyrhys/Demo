package com.zparkep.service;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Qupu;

public interface QupuService {

	int add(Qupu qupu)throws SQLException;

	List<Qupu> selectByTo_id(int to_id)throws SQLException;

	int deleteById(int id)throws SQLException;

}
