package com.zparkep.bean;

public class Teacher {
	private Integer id;
	private String name;
	private String img;
	
	public Teacher() {
		super();
	}
	
	public Teacher(Integer id, String name, String img) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
	}

	public Teacher(String name, String img) {
		super();
		this.name = name;
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", img=" + img + "]";
	}

	
}
