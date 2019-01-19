package com.zparkep.dao.impl;


import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.zparkep.dao.CoDao;

public class CoDaoImplTest {
	private CoDao coDao;
	
	@Before
	public void fun() {
		coDao = new CoDaoImpl();
	}
	@Test
	public void testInsertCoToOpus() throws SQLException {
		coDao.insertCoToOpus(2, 1);
	}
	@Test
	public void testInsertCoToTopus() throws SQLException {
		coDao.insertCoToTopus(1, 1);
	}

}
