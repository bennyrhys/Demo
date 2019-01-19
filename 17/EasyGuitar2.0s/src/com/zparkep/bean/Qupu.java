package com.zparkep.bean;

public class Qupu {
	private int id;
	private int to_id;
	private String img; 
	
	public Qupu() {
		super();
	}

	
	public Qupu(int to_id, String img) {
		super();
		this.to_id = to_id;
		this.img = img;
	}


	public Qupu(int id, int to_id, String img) {
		super();
		this.id = id;
		this.to_id = to_id;
		this.img = img;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTo_id() {
		return to_id;
	}

	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Qupu [id=" + id + ", to_id=" + to_id + ", img=" + img + "]";
	}
	
	
	
}
