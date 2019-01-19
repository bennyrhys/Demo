package com.zparkep.dao;

import java.sql.SQLException;
import java.util.List;

import com.zparkep.bean.Opus;

public interface OpusDao {
	/**
	 * 将参数opus插入到数据库中
	 *
	 * @param OpusDao
	 * @return
	 * @throws SQLException
	 */
	int insertOpus(Opus opus) throws SQLException;

	/**
	 * 通过教程id来删除数据库中指定教程
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteOpusById(Integer id) throws SQLException;

	/**
	 * 更新数据库中的教程
	 *
	 * @param OpusDao
	 * @return
	 * @throws SQLException
	 */
	int updateOpus(Opus opus) throws SQLException;

	/**
	 * 通过教程id来查找数据库中的教程
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Opus selectOpusById(Integer id) throws SQLException;

	/**
	 * 查找数据库中所有教程
	 *
	 * @param OpusDao
	 * @return
	 * @throws SQLException
	 */
	List<Opus> selectOpusAll() throws SQLException;

	List<Opus> selectOpusByCondition(Opus opus) throws SQLException;

}
