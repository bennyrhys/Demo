package com.zparkep.bean;


public class Cdetails {
	private int id;
	private int c_id;
	private String comment;
	private String date;
	private String username;
	
	public Cdetails() {
		super();
	}

	
	public Cdetails(int c_id, String comment, String date, String username) {
		super();
		this.c_id = c_id;
		this.comment = comment;
		this.date = date;
		this.username = username;
	}


	public Cdetails(int id, int c_id, String comment, String date, String username) {
		super();
		this.id = id;
		this.c_id = c_id;
		this.comment = comment;
		this.date = date;
		this.username = username;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Cdetails [id=" + id + ", c_id=" + c_id + ", comment=" + comment + ", date=" + date + ", username="
				+ username + "]";
	}
	
}
