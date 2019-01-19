package com.zparkep.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.smartcardio.ResponseAPDU;

import com.zparkep.bean.Administrator;
import com.zparkep.bean.User;
import com.zparkep.service.UserService;
import com.zparkep.service.impl.UserServiceImpl;
import com.zparkep.util.MD5;

@MultipartConfig   //@MultipartConfig标注主要是为了辅助Servlet3.0中HttpServletRequest提供的对上传文件的支持
@WebServlet(urlPatterns = "/servlet/user")   //该注解将会在部署时被容器处理，容器将根据具体的属性配置将相应的类部署为 Servlet。
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "add":
			try {
				add(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				list(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				delete(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "findById":
			try {
				findById(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				update(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		
		case "login":
			try {
				login(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} // alt+shift+m
			break;
		case "logout":
			logout(request, response);
			break;
		case "regist":
			try {
				regist(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "skip":
			try {
				skip(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "search":
			try {
				search(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}
	
	private void skip(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
		
		String idStr = req.getParameter("id");  
		int id = 0;
		if (idStr != null && idStr.trim().length() > 0)
			id = Integer.parseInt(idStr);
		
		String username = req.getParameter("username");   
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password1");
		String ageStr = req.getParameter("age");  //将输入框中字符串类型的年龄转换为整数类型
		int age = 0;
		if(ageStr == null || ageStr.equals("")) {
		    age = 0;
		} else {
		    age = Integer.parseInt(ageStr);
		}
		String gender = req.getParameter("gender");
		String mail = req.getParameter("mail");
		
		String intro = req.getParameter("intro");
		String addr = req.getParameter("addr");
		String weibo = req.getParameter("weibo");
		
		//图片上传
		String fileName = uploadImg(req);
		String img = "";
		if(fileName ==null ) {//如果没有更改则使用原来的图片
			img = req.getParameter("yuanLaiImg");
		}else {
			img = "upload/user/" + fileName;
		}
		System.out.println("-----"+img);   //输出图片的保存路径
		
		
		
	    User user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);//将输入框中的值赋给user对象
	    HttpSession session = req.getSession();
		session.setAttribute("user", user);
	    
	    int res = userService.updateuser(user);  //执行结果
		
		System.out.println(res);
		if(res == 1) {//执行成功，跳转成功页面，2s后跳回用户列表页面
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath+"/auth/user.jsp");
		}else {  //执行失败，重新到数据库中查找该条数据
			req.setAttribute("aim", "servlet/user?op=findById&id="+id);
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}

	//根据输入框中输入的条件进行用户的搜索，返回不同的结果
	private void search(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String username = req.getParameter("username");   
		String nickname = req.getParameter("nickname");
		String gender = req.getParameter("gender");
		String intro = req.getParameter("intro");
		
		String addr = req.getParameter("addr");
		String lowageStr = req.getParameter("lowage");  //将查找的字符串字段年龄转换成整数类型
		int lowage = 0;
		if(lowageStr == null || lowageStr.equals("")) {
			lowage = 0;
		} else {
			lowage = Integer.parseInt(lowageStr);
		}
		String highageStr = req.getParameter("highage");  //将查找的字符串字段年龄转换成整数类型
		int highage= 0;
		if(highageStr == null || highageStr.equals("")) {
			highage = 0;
		} else {
			highage = Integer.parseInt(highageStr);   //获取搜索输入框中传来的各个参数的值
		}
		
		User user = new User();   //新建一个user对象
		user.setUsername(username);
		user.setNickname(nickname);
		user.setGender(gender);
		user.setIntro(intro);
		user.setAddr(addr);
        user.setLowage(lowage);
        user.setHighage(highage);      //将user中的值全部换成传来的值
		
		List<User> userList = userService.selectByCondition(user);  //调用service的条件搜索方法，并将user参数传递过去
		
		req.setAttribute("userList", userList);  //将返回结果放入到request中，后面可以通过requestScope获取其值
		req.getRequestDispatcher("/auth/user/list.jsp").forward(req, resp);  //请求转达到用户列表页面
	}
	
	/**
	 * 管理员对用户信息进行更改
	 * @param req
	 * @param resp
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");  
		int id = 0;
		if (idStr != null && idStr.trim().length() > 0)
			id = Integer.parseInt(idStr);
		
		String username = req.getParameter("username");   
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password1");
		String ageStr = req.getParameter("age");  //将输入框中字符串类型的年龄转换为整数类型
		int age = 0;
		if(ageStr == null || ageStr.equals("")) {
		    age = 0;
		} else {
		    age = Integer.parseInt(ageStr);
		}
		String gender = req.getParameter("gender");
		String mail = req.getParameter("mail");
		
		String intro = req.getParameter("intro");
		String addr = req.getParameter("addr");
		String weibo = req.getParameter("weibo");
		
		//图片上传
		String fileName = uploadImg(req);
		String img = "";
		if(fileName ==null ) {//如果没有更改则使用原来的图片
			img = req.getParameter("yuanLaiImg");
		}else {
			img = "upload/user/" + fileName;
		}
		System.out.println("-----"+img);   //输出图片的保存路径
		
		
		
	    User user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);//将输入框中的值赋给user对象
	
		int res = userService.updateuser(user);  //执行结果
		
		System.out.println(res);
		if(res == 1) {//执行成功，跳转成功页面，2s后跳回用户列表页面
			req.setAttribute("aim", "servlet/user?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}else {  //执行失败，重新到数据库中查找该条数据
			req.setAttribute("aim", "servlet/user?op=findById&id="+id);
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}
	
	
	
	
	
	//根据用户的唯一标识id对用户进行查找
	private void findById(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = 0;
		if(idStr != null && idStr.trim().length()>0)
			id = Integer.parseInt(idStr);
		User user = userService.findById(id);  //根据ID进行查找，返回该用户的全部信息
		req.setAttribute("user", user);
		req.getRequestDispatcher("/auth/user/edit.jsp").forward(req, resp);
	}
	
	//对非法用户进行删除
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String idStr = req.getParameter("id");
		if(idStr != null && idStr.trim().length() >0) {
			int id = Integer.parseInt(idStr);
			int res = userService.deleteById(id);  //根据id对整条数据进行删除
			if(res ==1) {
				String contextPath = req.getContextPath();     //获取根目录
				resp.sendRedirect(contextPath+"/success.jsp");
			}
		}
	}

	//将所有的用户列举出来
	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		List<User> userList = userService.selectAll();
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/auth/user/list.jsp").forward(req, resp);  //请求转发到用户列表页面
	}

	//添加用户
	private void add(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException, SQLException {
		String idStr = req.getParameter("id");
		int id = 0;
		if (idStr != null && idStr.trim().length() > 0)
			id = Integer.parseInt(idStr);
		
		String username = req.getParameter("username");   
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String ageStr = req.getParameter("age");  //将输入框中字符串类型的年龄转换为整数类型
		int age = 0;
		if (ageStr != null && ageStr.trim().length() > 0)
			age = Integer.parseInt(ageStr);
		String gender = req.getParameter("gender");
		String mail = req.getParameter("mail");
		String intro = req.getParameter("intro");
		String addr = req.getParameter("addr");
		String weibo = req.getParameter("weibo");
		
		//上传图片
		String fileName = uploadImg(req);
		String img = "";
		img = "upload/user/" + fileName;
		System.out.println("-----"+img);
		
		
		User user = new User(id, username, nickname, password, age, gender, mail, img, intro, addr, weibo);
		int res = userService.adduser(user);
		if(res == 1) {
			req.setAttribute("aim", "servlet/user?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}else {
			//如果不成功，先显示失败页面再跳转添加页面
			req.setAttribute("aim", "auth/user/add.jsp");
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}

	}
  
	
	//注册功能的实现
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {

		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String ageStr = request.getParameter("age"); 
		int age = 0;
		if(ageStr == null || ageStr.equals("")) {
		    age = 0;
		} else {
		    age = Integer.parseInt(ageStr);
		}
		String gender = request.getParameter("gender");
		String mail = request.getParameter("mail");
		
		String intro = request.getParameter("intro");
		String addr = request.getParameter("addr");
		String weibo = request.getParameter("weibo");  
		
		String fileName = uploadImg(request);
		String img = "";
		img = "upload/user/" + fileName;
		System.out.println("-----"+img);
		
		HttpSession session = request.getSession();
		if (!(password1 != null && password1.equals(password2))) { //两次密码一致
			String contextpath = request.getContextPath();
			session.setAttribute("aim", "regist.jsp");
			
	        response.sendRedirect(contextpath+"/failed.jsp");
			return;// 直接返回不执行后面的语句
		}

		User user = new User(username, nickname, password1, age, gender, mail, img, intro, addr, weibo);

		User registUser = userService.regist(user);

		if (user != null) {
			System.out.println(registUser);
			// 注册成功之后将当前注册用户的信息放到Request中
			session.setAttribute("currentUser", registUser);  //此处将信息保存到session中，因为重定向不能携带request中的信息
		    //	request.getRequestDispatcher("/login.jsp").forward(request, response);
		    String contextPath = request.getServletContext().getContextPath();
		    response.sendRedirect(contextPath+"/login.jsp");  //此处用重定向，方便登录页面成功刷新，用请求转发会导致登录页面的样式无法刷新
		}

	}

	//登出功能
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);  //清空登录判断标志user退出登录
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/login.jsp");
	}

	//登录功能
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("login");
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkCode = request.getParameter("checkCode"); //获取用户输入的验证码

		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		User user = userService.login(name, pwd);

		if (user != null && piccode.equalsIgnoreCase(checkCode)) {
			HttpSession session = request.getSession();
			// 从request出获取session
			session.setAttribute("user", user);

			List<User> userList = userService.selectAll();
			session.setAttribute("userList", userList);
            String contextPath = request.getServletContext().getContextPath();
		    response.sendRedirect(contextPath+"/main.jsp");
		}
		else {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/login.jsp");
		}
	}
	

	
	private String uploadImg(HttpServletRequest req) throws IOException, ServletException {
		//文件上传
		String savePath = req.getServletContext().getRealPath("/");
		savePath = savePath + "upload\\user";

		System.out.println(savePath);

		File dir = new File(savePath);
		if (!dir.exists())
			dir.mkdirs();

        //Servlet3.0新增了request.getParts()/getPart(String filename) api，用于获取使用multipart/form-data格式传递的http请求的请求体，通常用于获取上传文件。
		Collection<Part> parts = req.getParts();
		
		String fileName = "";
		if (parts.size() > 0) {
			Part part = req.getPart("img");
			String header = part.getHeader("content-disposition");
			System.out.println(header);
			// 获取文件后缀名
			if(header.lastIndexOf('.') <0) {
				return null;
			}
			fileName = getFileName(header);
			// 输出文件保存路径
			part.write(savePath + File.separator + fileName);
		}
		System.out.println("ok");
		return fileName;
	}

	private String getFileName(String header) {
		String suffix = header.substring(header.lastIndexOf('.'), header.length() - 1);
		System.out.println(suffix);

		return UUID.randomUUID().toString() + suffix;
	}

}
