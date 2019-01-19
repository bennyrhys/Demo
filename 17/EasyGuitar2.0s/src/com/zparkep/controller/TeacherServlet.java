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
import javax.servlet.http.Part;
import javax.smartcardio.ResponseAPDU;

import org.apache.catalina.connector.Response;

import com.zparkep.bean.Teacher;
import com.zparkep.bean.User;
import com.zparkep.dao.TeacherDao;
import com.zparkep.service.TeacherService;
import com.zparkep.service.impl.TeacherServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = "/servlet/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService teacherService = new TeacherServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		switch (op) {
		case "add":
			try {
				add(request, response);
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
		case "findById":
			try {
				findById(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				list(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "search":
			try {
				search(request,response);
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
		default:
			break;
		}
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		if(idStr!=null&&idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}
		int res = teacherService.deleteById(id);
		if(res ==1) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/auth/teacher/list.jsp");
		}
	}


	private void search(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		if(idStr!=null&&idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}
		String name = request.getParameter("name");
		
		
		
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setName(name);
		
		List<Teacher> teacherList = teacherService.selectByCondition(teacher);
		request.setAttribute("teacherList", teacherList);
		request.getRequestDispatcher("/auth/teacher/list.jsp").forward(request, response);;
	}


	private void list(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Teacher> teacherList = teacherService.selectAll();
		request.setAttribute("teacherList", teacherList);
		request.getRequestDispatcher("/auth/teacher/list.jsp").forward(request,response);
	}


	private void findById(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		if(idStr != null && idStr.trim().length()>0)
			id = Integer.parseInt(idStr);
		Teacher teacher = teacherService.findById(id);
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("/auth/teacher/edit.jsp").forward(request, response);
	}


	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		String idStr = request.getParameter("id");
		int id = 0;
		if(idStr!=null && idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}
		String name = request.getParameter("name");
		
		//上传图片
		String fileName = uploadImg(request);
		String img = "";
		if(fileName ==null ) {//如果没有更改则使用原来的图片
			img = request.getParameter("yuanLaiImg");
		}else {
			img = "upload/user/" + fileName;
		}
		System.out.println("-----"+img);
		
		
		Teacher teacher = new Teacher(id, name, img);
		request.setAttribute("teacher", teacher);
		int res = teacherService.updateTeacher(teacher);
		if(res == 1) {
			request.setAttribute("aim", "servlet/teacher?op=list");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
			//如果不成功，先显示失败页面再跳转修改页面
			request.setAttribute("aim", "servlet/teacher?op=findByid&id="+id);
			request.getRequestDispatcher("/failed.jsp").forward(request, response);
		}
	}


	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		String idStr = request.getParameter("id");
		int id = 0;
		if(idStr!=null&&idStr.trim().length()>0) {
			id = Integer.parseInt(idStr);
		}
		String name = request.getParameter("name");
		
		//上传图片
		String fileName = uploadImg(request);
		String img = "";
		img = "upload/user/" + fileName;
		System.out.println("-----"+img);
		
		
		Teacher teacher = new Teacher(id, name, img);
		int res = teacherService.addTeacher(teacher);
		if(res == 1) {
			request.setAttribute("aim", "servlet/teacher?op=list");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
			//如果不成功，先显示失败页面再跳转添加页面
			request.setAttribute("aim", "auth/teacher/add.jsp");
			request.getRequestDispatcher("/failed.jsp").forward(request, response);
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



