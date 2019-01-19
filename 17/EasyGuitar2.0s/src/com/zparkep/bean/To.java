package com.zparkep.bean;

public class To {
	private Integer id;
	private String name;
	private String username;
	private String img;
	private String video;
	private String singer;    
	private String state;     //风格
	private Integer cnumber;  //评论数量
	private Integer lnumber;  //收藏量

	public To() {
		super();
	}


	public To(String name, String username, String img, String video, String singer, String state, Integer cnumber,
			Integer lnumber) {
		super();
		this.name = name;
		this.username = username;
		this.img = img;
		this.video = video;
		this.singer = singer;
		this.state = state;
		this.cnumber = cnumber;
		this.lnumber = lnumber;
	}


	public To(Integer id, String name, String username, String img, String video, String singer, String state,
			Integer cnumber, Integer lnumber) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.img = img;
		this.video = video;
		this.singer = singer;
		this.state = state;
		this.cnumber = cnumber;
		this.lnumber = lnumber;
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

	public Integer getCnumber() {
		return cnumber;
	}

	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}

	public Integer getLnumber() {
		return lnumber;
	}

	public void setLnumber(Integer lnumber) {
		this.lnumber = lnumber;
	}

	@Override
	public String toString() {
		return "To [id=" + id + ", name=" + name + ", username=" + username + ", img=" + img + ", video=" + video
				+ ", singer=" + singer + ", state=" + state + ", cnumber=" + cnumber + ", lnumber=" + lnumber + "]";
	}

	private Integer lowl;
	private Integer highl;

	public Integer getLowl() {
		return lowl;
	}


	public void setLowl(Integer lowl) {
		this.lowl = lowl;
	}


	public Integer getHighl() {
		return highl;
	}


	public void setHighl(Integer highl) {
		this.highl = highl;
	}




}
