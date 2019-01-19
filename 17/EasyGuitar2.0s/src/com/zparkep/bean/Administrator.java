package com.zparkep.bean;

public class Administrator {
	private String houname;
	private String password;
	
	public String getHouname() {
		return houname;
	}
	
	public void setHouname(String houname) {
		this.houname = houname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Administrator(String houname, String password) {
		super();
		this.houname = houname;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Administrator [houname=" + houname + ", password=" + password + "]";
	}
	
	

}
