package com.zparkep.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(urlPatterns = "/servlet/*", filterName = "1", 
	initParams = {@WebInitParam(name = "encoding", value = "utf-8") })
public class CharaterSetFilter implements Filter {

	private String encoding;
	
	@Override
	public void destroy() {
		System.out.println("destrory");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		System.out.println("charsetFilter 1");
		chain.doFilter(request, response);
		System.out.println("charsetFilter 2");
	}

	// initialize
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		System.out.println("charset init");
	}

}
