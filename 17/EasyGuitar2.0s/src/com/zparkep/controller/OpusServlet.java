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
import com.zparkep.service.CdService;
import com.zparkep.service.CoService;
import com.zparkep.service.OpusService;
import com.zparkep.service.impl.CdServiceImpl;
import com.zparkep.service.impl.CoServiceImpl;
import com.zparkep.service.impl.OpusServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = "/servlet/opus")
public class OpusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private OpusService opusService = new OpusServiceImpl();
	private CoService coService = new CoServiceImpl();
	private CdService cdService = new CdServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
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

	private void userlist(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		List<Opus> opusList = opusService.selectAll();
		HttpSession session = req.getSession();
		session.setAttribute("opusList", opusList);
		req.getRequestDispatcher("/opus/opus/userlist.jsp").forward(req, resp);
	}

	private void show(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		System.out.println("----"+id);
		int c_id = coService.selectByOpus_id(id);
		List<Cdetails> cList = cdService.selectByC_id(c_id);
		Opus opus = opusService.selectById(id);
		HttpSession session = req.getSession();
		session.setAttribute("cList", cList);
		session.setAttribute("opus", opus);
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath+"/opus/opus/show.jsp");
	}

	private void select(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String singer = req.getParameter("singer");
		String state = req.getParameter("state");

		Opus opus = new Opus();
		opus.setName(name);
		opus.setUsername(username);
		opus.setSinger(singer);
		opus.setState(state);

		List<Opus> opusList = opusService.selectByCondition(opus);

		HttpSession session = req.getSession();
		session.setAttribute("opusList", opusList);

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
		String state = req.getParameter("state");
		String qupustate = req.getParameter("qupustate");
		String singer = req.getParameter("singer");

		String fileName = uploadImg(req, "imgs", "img");
		String img = "";
		if (fileName == null) {
			img = req.getParameter("lastImg");
		} else {
			img = fileName;
		}
		System.out.println("----" + img);
	    String video = req.getParameter("video");
		Opus opus = new Opus(id, name, username, img, video, state, qupustate, singer);
		int res = opusService.update(opus);
		System.out.println(opus);
		System.out.println(res);
		if (res == 1) {
			req.setAttribute("aim", "servlet/opus?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		} else {
			req.setAttribute("aim", "servlet/opus?op=find&id=" + id);
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

		Opus opus = opusService.selectById(id);
		HttpSession session = req.getSession();
		session.setAttribute("opus", opus);
		req.getRequestDispatcher("/opus/opus/update.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		int c_id = coService.selectByOpus_id(id);
		int a = cdService.deleteByC_id(c_id);
		int b = coService.deleteByOpus_id(id);
		System.out.println("aaaa"+a);
		System.out.println("bbbb"+b);
		int res = opusService.deleteById(id);
		if (res == 1) {
			req.setAttribute("aim", "servlet/opus?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		} else {
			req.setAttribute("aim", "servlet/opus?op=list");
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		List<Opus> opusList = opusService.selectAll();
		HttpSession session = req.getSession();
		session.setAttribute("opusList", opusList);
		req.getRequestDispatcher("/opus/opus/list.jsp").forward(req, resp);
	}

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, SQLException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String singer = req.getParameter("singer");
		String qupustate = req.getParameter("qupustate");
		String state = req.getParameter("state");
		String img = uploadImg(req, "imgs", "img");
	    String video = req.getParameter("video");

		Opus opus = new Opus(name, username, img, video, singer, qupustate, state);
		int res = opusService.addOpus(opus);
		if (res == 1) {
			req.setAttribute("aim", "servlet/opus?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		} else {
			req.setAttribute("aim", "/opus/opus/add.jsp");
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}

	private String uploadImg(HttpServletRequest req, String path, String sth) throws IOException, ServletException {
		String savePath = req.getServletContext().getRealPath("/");
		savePath = savePath + "upload\\" + "opus\\" + "opus\\" + path;

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
		String s = "upload/opus/opus/" + path + "/" + fileName;
		return s;
	}

	private String getFileName(String header) {
		String suffix = header.substring(header.lastIndexOf('.'), header.length() - 1);
		System.out.println(suffix);

		return UUID.randomUUID().toString() + suffix;
	}
}
