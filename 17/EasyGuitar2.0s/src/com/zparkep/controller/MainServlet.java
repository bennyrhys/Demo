package com.zparkep.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zparkep.bean.Opus;
import com.zparkep.bean.To;
import com.zparkep.service.OpusService;
import com.zparkep.service.ToService;
import com.zparkep.service.impl.OpusServiceImpl;
import com.zparkep.service.impl.ToServiceImpl;


@WebServlet(urlPatterns = "/servlet/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ToService toService = new ToServiceImpl();
	private OpusService opusService = new OpusServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<Opus> opusList = opusService.selectAll();
			req.setAttribute("opusList", opusList);
			List<To> toList = toService.selectAll();
			toList.forEach(System.out::println);
			req.setAttribute("toList", toList);
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath+"/main.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
