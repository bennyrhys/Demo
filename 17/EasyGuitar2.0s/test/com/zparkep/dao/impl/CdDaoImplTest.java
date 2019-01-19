package com.zparkep.dao.impl;


import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.zparkep.bean.Cdetails;
import com.zparkep.dao.CdDao;

public class CdDaoImplTest {
	
	private CdDao cdDao;
	
	@Before
	public void fun(){
		cdDao = new CdDaoImpl();
	}
	@Test
	public void testInsertCd() throws SQLException {
		Cdetails cd = new Cdetails(1, "hh", "wshfkj", "username");
		int res = cdDao.insertCd(cd);
		System.out.println(res);
	}
	@Test
	public void testdeleteCdByC_id() throws SQLException {
		int res = cdDao.deleteCdByC_id(5);
		System.out.println(res);
	}
}
