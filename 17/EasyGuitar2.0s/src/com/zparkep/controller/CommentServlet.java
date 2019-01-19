package com.zparkep.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zparkep.bean.Cdetails;
import com.zparkep.bean.User;
import com.zparkep.service.CdService;
import com.zparkep.service.CoService;
import com.zparkep.service.impl.CdServiceImpl;
import com.zparkep.service.impl.CoServiceImpl;

@WebServlet(urlPatterns = "/servlet/comment")
public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoService coService = new CoServiceImpl();
	private CdService cdService = new CdServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");

		switch (op) {
		case "add":
			try {
				add(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				delete(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		default:
			break;
		}

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String idStr = req.getParameter("id");
		int id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		System.out.println(id);
		int res = cdService.deleteById(id);
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		String idd = req.getParameter("idd");
		if(idd != null) {
			session.setAttribute("id2", idd);
			if (res == 1) {
				session.setAttribute("aim", "servlet/opus?op=show");
				resp.sendRedirect(contextPath + "/success.jsp");
			} else {
				session.setAttribute("aim", "servlet/opus?op=show");
				resp.sendRedirect(contextPath + "/failed.jsp");
			}
		}else {
			String to_id = req.getParameter("to_id");
			idd = to_id;
			session.setAttribute("id2", idd);
			if (res == 1) {
				session.setAttribute("aim", "servlet/to?op=show");
				resp.sendRedirect(contextPath + "/success.jsp");
			} else {
				session.setAttribute("aim", "servlet/to?op=show");
				resp.sendRedirect(contextPath + "/failed.jsp");
			}
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String comment1 = req.getParameter("comment1");// 从表单中获取评论内容
		String comment2 = req.getParameter("comment2");

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");// 获取用户信息
		Integer user_id = user.getId();// 获取用户ID
		String username = user.getUsername();// 获取用户名
		// 获取时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		if (comment1 != null) {
			String opus_idStr = req.getParameter("opus_id");
			int opus_id = 0;
			if (opus_idStr != null && opus_idStr.trim().length() > 0) {
				opus_id = Integer.parseInt(opus_idStr);
			}
			int c_id = coService.addToOpus(user_id, opus_id);
			Cdetails cd = new Cdetails(c_id, comment1, time, username);
			cdService.add(cd);
			session.setAttribute("opus_id", opus_id);
			req.setAttribute("id2", opus_id);
			req.setAttribute("aim", "servlet/opus?op=show");
		}else if (comment2 != null) {
			String to_idStr = req.getParameter("to_id");
			int to_id = 0;
			if (to_idStr != null && to_idStr.trim().length() > 0) {
				to_id = Integer.parseInt(to_idStr);
			}
			int c_id = coService.addToTopus(user_id, to_id);
			Cdetails cd = new Cdetails(c_id, comment2, time, username);
			cdService.add(cd);
			session.setAttribute("to_id", to_id);
			req.setAttribute("id2", to_id);
			req.setAttribute("aim", "servlet/to?op=show");
		}
		req.getRequestDispatcher("/success.jsp").forward(req, resp);
	}
}
