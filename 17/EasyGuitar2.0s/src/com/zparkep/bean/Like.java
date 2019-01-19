package com.zparkep.bean;

public class Like {
	private String name;
	private String username;
	private String img;
	private String singer;
	private String state;

	public Like() {
		super();
	}

	public Like(String name, String username, String img, String singer, String state) {
		super();
		this.name = name;
		this.username = username;
		this.img = img;
		this.singer = singer;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Like [name=" + name + ", username=" + username + ", img=" + img + ", singer=" + singer + ", state="
				+ state + "]";
	}

}
