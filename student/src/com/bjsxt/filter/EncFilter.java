package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncFilter  implements Filter{
    
	String  enc;
	
	//销毁的方法----执行一次
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
    //请求处理----每一次请求都会执行
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		   //【1】执行预处理操作
		   req.setCharacterEncoding(enc);
		
		   //【2】执行下一个过滤器或者目标资源
		     chain.doFilter(req, resp);
		   
		   //【3】离开服务器之前的处理操作
		   
		
		
		
	}

	  //初始化---执行一次
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		//读取全局的参数
		enc=arg0.getServletContext().getInitParameter("enc");
		
		
		
	}

}
