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
import com.zparkep.bean.Qupu;
import com.zparkep.bean.To;
import com.zparkep.service.CdService;
import com.zparkep.service.CoService;
import com.zparkep.service.QupuService;
import com.zparkep.service.ToService;
import com.zparkep.service.impl.CdServiceImpl;
import com.zparkep.service.impl.CoServiceImpl;
import com.zparkep.service.impl.ToServiceImpl;
import com.zparkep.service.impl.qupuServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = "/servlet/to")
public class ToServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ToService toService = new ToServiceImpl();
	private CoService coService = new CoServiceImpl();
	private CdService cdService = new CdServiceImpl();
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
		case "list":
			try {
				list(req, resp);
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
		case "find":
			try {
				find(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				update(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "select":
			try {
				select(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "show":
			try {
				show(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "userlist":
			try {
				userlist(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private void userlist(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		List<To> toList = toService.selectAll();
		HttpSession session = req.getSession();
		session.setAttribute("toList", toList);
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath+"/opus/to/userlist.jsp");
	}

	private void show(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		System.out.println("to"+id);
		int c_id= coService.selectByTopus_id(id);
		List<Cdetails> cList2= cdService.selectByC_id(c_id);
		To to = toService.selectById(id);
		List<Qupu> qupuList = qupuService.selectByTo_id(id);
		HttpSession session = req.getSession();
		session.setAttribute("qupuList", qupuList);
		session.setAttribute("cList2", cList2);
		session.setAttribute("to", to);
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath+"/opus/to/show.jsp");
	}

	private void select(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String singer = req.getParameter("singer");
		String state = req.getParameter("state");
		String lowlStr = req.getParameter("lowl");
		Integer lowl = 0;
		if(lowlStr != null && lowlStr.trim().length() > 0){
			lowl = Integer.parseInt(lowlStr);
		}
		String highlStr = req.getParameter("highl");
		Integer highl = 0;
		if(highlStr != null && highlStr.trim().length() > 0){
			highl = Integer.parseInt(highlStr);
		}

		To to = new To();
		to.setName(name);
		to.setUsername(username);
		to.setSinger(singer);
		to.setState(state);
		to.setLowl(lowl);
		to.setHighl(highl);

		List<To> toList = toService.selectByCondition(to);

		HttpSession session = req.getSession();
		session.setAttribute("toList", toList);

		String aim = req.getParameter("aim");
		req.getRequestDispatcher(aim).forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String singer = req.getParameter("singer");
		String state = req.getParameter("state");

		String fileName = uploadImg(req, "imgs", "img");
		String img = "";
		if (fileName == null) {
			img = req.getParameter("lastImg");
		} else {
			img = fileName;
		}
		System.out.println("----" + img);
		
		String video = req.getParameter("video");
		To to = new To(id, name, username, img, video, singer, state, 0, 0);
		int res = toService.update(to);
		if (res == 1) {
			req.setAttribute("aim", "servlet/to?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		} else {
			req.setAttribute("aim", "servlet/to?op=find&id=" + id);
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}

	private void find(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}

		To to = toService.selectById(id);
		HttpSession session = req.getSession();
		session.setAttribute("to", to);
		req.getRequestDispatcher("/opus/to/update.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		
		int c_id = coService.selectByTopus_id(id);
		int a = cdService.deleteByC_id(c_id);
		int b = coService.deleteByTo_id(id);
		System.out.println("aaaa"+a);
		System.out.println("bbbb"+b);
		int res = toService.deleteById(id);
		if (res == 1) {
			req.setAttribute("aim", "servlet/to?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		} else {
			req.setAttribute("aim", "servlet/to?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		List<To> toList = toService.selectAll();
		HttpSession session = req.getSession();
		String to_idStr = req.getParameter("id2");
		int to_id = 0;
		if(to_idStr != null && to_idStr.trim().length() > 0) {
			to_id = Integer.parseInt(to_idStr);
		}
		List<Qupu> qpList = qupuService.selectByTo_id(to_id);
		session.setAttribute("qupuList", qpList);
		session.setAttribute("toList", toList);
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath+"/opus/to/list.jsp");
	}

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String singer = req.getParameter("singer");
		String state = req.getParameter("state");
		String img = uploadImg(req, "imgs", "img");
		String video = req.getParameter("video");

		To to = new To(name, username, img, video, singer, state, 0, 0);
		int res = toService.addTo(to);
		if (res == 1) {
			req.setAttribute("aim", "servlet/to?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		} else {
			req.setAttribute("aim", "/opus/to/add.jsp");
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}

	private String uploadImg(HttpServletRequest req, String path, String sth) throws IOException, ServletException {
		String savePath = req.getServletContext().getRealPath("/");
		savePath = savePath + "upload\\" + "opus\\" + "to\\" + path;

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
		String s = "upload/opus/to/" + path + "/" + fileName;
		return s;
	}

	private String getFileName(String header) {
		String suffix = header.substring(header.lastIndexOf('.'), header.length() - 1);
		System.out.println(suffix);

		return UUID.randomUUID().toString() + suffix;
	}
}
