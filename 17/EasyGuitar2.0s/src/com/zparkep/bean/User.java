package com.zparkep.bean;

/**
 * user的实体类，对各个属性进行封装，通过getter/setter的方法调用
 * 重写构造方法，方便后面的对象调用
 * @author lenovo
 *
 */
public class User {
	private Integer id;
	private String username;
	private String nickname;
	private String password;
	private Integer age;
	private String gender;
	private String mail;
	private String img;
	private String intro;
	private String addr;
	private String weibo;
	
	public User() {
		super();
	}

	public User(Integer id, String username, String nickname, String password, Integer age, String gender, String mail,
			String img, String intro, String addr, String weibo) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.mail = mail;
		this.img = img;
		this.intro = intro;
		this.addr = addr;
		this.weibo = weibo;
	}

	public User(String username, String nickname, String password, Integer age, String gender, String mail, String img,
			String intro, String addr, String weibo) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.mail = mail;
		this.img = img;
		this.intro = intro;
		this.addr = addr;
		this.weibo = weibo;
	}

	

	public User(String username, String nickname, String gender, String intro, String addr, Integer lowage,
			Integer highage) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.gender = gender;
		this.intro = intro;
		this.addr = addr;
		this.lowage = lowage;
		this.highage = highage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", age=" + age + ", gender=" + gender + ", mail=" + mail + ", img=" + img + ", intro=" + intro
				+ ", addr=" + addr + ", weibo=" + weibo + "]";
	}
	
	////////////////
	private Integer lowage;
	private Integer highage;

	public Integer getLowage() {
		return lowage;
	}

	public void setLowage(Integer lowage) {
		this.lowage = lowage;
	}

	public Integer getHighage() {
		return highage;
	}

	public void setHighage(Integer highage) {
		this.highage = highage;
	}
	

}
