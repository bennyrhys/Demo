package com.zparkep.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zparkep.bean.Administrator;
import com.zparkep.bean.User;
import com.zparkep.service.AdmiService;
import com.zparkep.service.impl.AdminiServiceImpl;

/**
 * Servlet implementation class AdminiServlet
 */
@WebServlet(urlPatterns = "/servlet/admini")
public class AdminiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdmiService admiService = new AdminiServiceImpl();
       
    public AdminiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "houlogin":
			try {
				houlogin(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

}




//后台登录
private void houlogin(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
			String houname = request.getParameter("uname");
			String password = request.getParameter("pwd");
			Administrator administrator = admiService.houlogin(houname, password);
			if(administrator!=null) {
				HttpSession session = request.getSession();
				// 从request出获取session
				session.setAttribute("admini", administrator);
	            String contextPath = request.getServletContext().getContextPath();
			    response.sendRedirect(contextPath+"/hou.html");
			}else {
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath+"/houlogin.jsp");
			}
			
		}
	}