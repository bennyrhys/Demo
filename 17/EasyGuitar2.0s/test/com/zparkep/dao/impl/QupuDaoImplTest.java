package com.zparkep.dao.impl;


import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.zparkep.bean.Qupu;
import com.zparkep.dao.QupuDao;

public class QupuDaoImplTest {
	
	private QupuDao qupuDao;
	
	@Before
	public void fun() {
		qupuDao = new QupuDaoImpl();
	}
	@Test
	public void testInsertQupu() throws SQLException {
		Qupu qupu = new Qupu(2, "img");
		int res = qupuDao.insertQupu(qupu);
		System.out.println(res);
	}

	@Test
	public void testSelectByTo_id() throws SQLException {
		qupuDao.selectByTo_id(14).forEach(System.out::println);
	}
	
	@Test
	public void testdeleteById() throws SQLException {
		int res = qupuDao.deleteById(12);
		System.out.println(res);
	}

}
