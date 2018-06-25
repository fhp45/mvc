package springmvc.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IPFilter implements Filter{
	//被禁止的IP,需要在web.xml中filter的init-param中配置ip的值
	private String ip;
	private FilterConfig filterConfig;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.ip = filterConfig.getInitParameter("ip");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String remoteIP = request.getRemoteAddr();
		if(remoteIP.equals(ip)) {
			response.setCharacterEncoding("gbk2312");
			PrintWriter out = response.getWriter();
			out.println("<b>你的IP地址被禁止访问！</b>");
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
}
