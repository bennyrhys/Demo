package com.zparkep.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zparkep.bean.Like;
import com.zparkep.bean.Opus;
import com.zparkep.bean.To;
import com.zparkep.service.OpusService;
import com.zparkep.service.ToService;
import com.zparkep.service.impl.OpusServiceImpl;
import com.zparkep.service.impl.ToServiceImpl;

@WebServlet(urlPatterns = "/servlet/like")
public class LikeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ToService toService = new ToServiceImpl();
	private OpusService opusService = new OpusServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		case "list":
			list(req, resp);
			break;
		case "show":
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath+"/opus/like.jsp");
			break;
		default:
			break;
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath+"/opus/like.jsp");
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		System.out.println(id);
		int res = 0;
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		Map<Integer, Like> likeList = (Map<Integer, Like>)session.getAttribute("likeList");
		Iterator<Integer> iterator = likeList.keySet().iterator();
		while(iterator.hasNext()){
			Integer key = iterator.next();
			if(id.equals(key)){
				likeList.remove(key);
			}
			res = 1;
		}

		if(res == 1){
			req.setAttribute("aim", "/servlet/like?op=list");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}else {
			req.setAttribute("aim", "/servlet/like?op=list");
			req.getRequestDispatcher("/failed.jsp").forward(req, resp);
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		String idStr = req.getParameter("id");
		Integer id = 0;
		if (idStr != null && idStr.trim().length() > 0) {
			id = Integer.parseInt(idStr);
		}
		HttpSession session = req.getSession();
		String to_id = req.getParameter("to_id");
		String idd = req.getParameter("idd");
		if(to_id != null) {
			idd = to_id;
			session.setAttribute("id2", idd);
			To to = toService.selectById(id);
			Like like = new Like(to.getName(), to.getUsername(), to.getImg(), to.getSinger(), to.getState());
			if (session.getAttribute("likeList") == null) {
				HashMap<Integer, Like> likeList = new HashMap<>();
				likeList.put(id, like);
				session.setAttribute("likeList", likeList);
			}else{
				@SuppressWarnings("unchecked")
				Map<Integer, Like> likeList = (Map<Integer, Like>)session.getAttribute("likeList");
				if(likeList.containsKey(id)){
					req.setAttribute("aim", "/servlet/main");
					req.getRequestDispatcher("/failed.jsp").forward(req, resp);
				}else {
					likeList.put(id, like);
					session.setAttribute("likeList", likeList);
				}
				
			}
			req.setAttribute("aim", "servlet/to?op=show");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}else if(idd != null){
			session.setAttribute("id2", idd);
			Opus opus = opusService.selectById(id);
			Like like = new Like(opus.getName(), opus.getUsername(), opus.getImg(), opus.getSinger(), opus.getState());
			if (session.getAttribute("likeList") == null) {
				HashMap<Integer, Like> likeList = new HashMap<>();
				likeList.put(id, like);
				session.setAttribute("likeList", likeList);
			}else{
				@SuppressWarnings("unchecked")
				Map<Integer, Like> likeList = (Map<Integer, Like>)session.getAttribute("likeList");
				if(likeList.containsKey(id)){
					req.setAttribute("aim", "/servlet/main");
					req.getRequestDispatcher("/failed.jsp").forward(req, resp);
				}else {
					likeList.put(id, like);
					session.setAttribute("likeList", likeList);
				}
				
			}
			req.setAttribute("aim", "servlet/opus?op=show");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}


	}
}
