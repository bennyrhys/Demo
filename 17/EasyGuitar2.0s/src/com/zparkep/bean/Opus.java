package com.zparkep.bean;

public class Opus {
	private int id;
	private String name;
	private String username;
	private String img;
	private String video;
	private String state;
	private String qupustate;
	private String singer;

	public Opus() {
		super();
	}
	public Opus(String name, String username, String img, String video, String state, String qupustate, String singer) {
		super();
		this.name = name;
		this.username = username;
		this.img = img;
		this.video = video;
		this.state = state;
		this.qupustate = qupustate;
		this.singer = singer;
	}

	public Opus(int id, String name, String username, String img, String video, String state, String qupustate,
			String singer) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.img = img;
		this.video = video;
		this.state = state;
		this.qupustate = qupustate;
		this.singer = singer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getQupustate() {
		return qupustate;
	}

	public void setQupustate(String qupustate) {
		this.qupustate = qupustate;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}


	@Override
	public String toString() {
		return "Opus [id=" + id + ", name=" + name + ", username=" + username + ", img=" + img + ", video=" + video
				+ ", state=" + state + ", qupustate=" + qupustate + ", singer=" + singer + "]";
	}


}
