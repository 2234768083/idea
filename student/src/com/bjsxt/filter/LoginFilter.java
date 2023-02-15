package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		   
		     HttpServletRequest   request=(HttpServletRequest) req;
		     
		     HttpServletResponse   response=(HttpServletResponse)resp;
		     //获得session中保存的对象
		     Object admin = request.getSession().getAttribute("admin");
		     
		     String uri = request.getRequestURI();
		     
		     System.out.println(uri);
		     if("/sscs/login.jsp".equals(uri)||"/sscs/servlet/UserServlet".equals(uri)){
		    	 
		    	 chain.doFilter(request, response);
		    	 
		     }else {
		    	 if(admin!=null){
			    	 //已经登陆
			    	chain.doFilter(request, response); 
			     }else {
			    	 
			    	 response.sendRedirect("/sscs/login.jsp");
			    	 return;
			     }
		    	 
		     }
		     
		     
		     
		     
		    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
