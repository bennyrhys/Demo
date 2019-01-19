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

import com.zparkep.bean.Cdetails;
import com.zparkep.bean.Opus;
import com.zparkep.bean.Qupu;
import com.zparkep.service.CdService;
import com.zparkep.service.CoService;
import com.zparkep.service.OpusService;
import com.zparkep.service.QupuService;
import com.zparkep.service.impl.CdServiceImpl;
import com.zparkep.service.impl.CoServiceImpl;
import com.zparkep.service.impl.OpusServiceImpl;
import com.zparkep.service.impl.qupuServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = "/servlet/qupu")
public class QupuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private QupuService qupuService = new qupuServiceImpl();
	
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
			break;
		default:
			break;
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String idStr = req.getParameter("id");
		int id = 0;
		if(idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		int res = qupuService.deleteById(id);
		String to_id = req.getParameter("to_id");
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		session.setAttribute("id2", to_id);
		session.setAttribute("id3", to_id);
		session.setAttribute("aim", "servlet/to?op=list");
		if(res == 1) {
			resp.sendRedirect(contextPath+"/success.jsp");
		}else {
			resp.sendRedirect(contextPath+"/failed.jsp");
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		String to_idStr = req.getParameter("to_id");
		int to_id = 0;
		if(to_idStr != null && to_idStr.trim().length() > 0) {
			to_id = Integer.parseInt(to_idStr);
		}
		String img = uploadImg(req, "teacher", "img");
		System.out.println(img);
		Qupu qupu = new Qupu(to_id, img);
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		int res = qupuService.add(qupu);
		session.setAttribute("aim", "servlet/to?op=list");
		session.setAttribute("id2", to_id);
		session.setAttribute("id3", to_id);
		if(res == 1) {
			resp.sendRedirect(contextPath+"/success.jsp");
		}else {
			resp.sendRedirect(contextPath+"/failed.jsp");
		}
	}
	private String uploadImg(HttpServletRequest req, String path, String sth) throws IOException, ServletException {
		String savePath = req.getServletContext().getRealPath("/");
		savePath = savePath + "upload\\" + path;

		System.out.println(savePath);

		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		Collection<Part> parts = req.getParts();
		String fileName = "";

		if (parts.size() > 0) {
			Part part = req.getPart(sth);
			String header = part.getHeader("content-disposition");
			System.out.println(header);
			if (header.lastIndexOf(".") < 0) {
				return null;
			}
			fileName = getFileName(header);
			part.write(savePath + File.separator + fileName);
		}
		System.out.println("ok");
		String s = "upload/" + path + "/" + fileName;
		return s;
	}

	private String getFileName(String header) {
		String suffix = header.substring(header.lastIndexOf('.'), header.length() - 1);
		System.out.println(suffix);

		return UUID.randomUUID().toString() + suffix;
	}
}
