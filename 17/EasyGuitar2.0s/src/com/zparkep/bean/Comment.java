package com.zparkep.bean;

public class Comment {
	private int id;
	private int opus_id;
	private int user_id;
	
	public Comment() {
		super();
	}
	public Comment(int opus_id, int user_id) {
		super();
		this.opus_id = opus_id;
		this.user_id = user_id;
	}
	public Comment(int id, int opus_id, int user_id) {
		super();
		this.id = id;
		this.opus_id = opus_id;
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOpus_id() {
		return opus_id;
	}
	public void setOpus_id(int opus_id) {
		this.opus_id = opus_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", opus_id=" + opus_id + ", user_id=" + user_id + "]";
	}
	
	private int to_id;

	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	
}
