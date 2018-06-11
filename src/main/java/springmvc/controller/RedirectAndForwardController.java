package springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectAndForwardController {
	/**
	 * 重定向方法只能将请求转发到同一Web站点的其它组件，下面两种方式实现重定向，多数情况下使用第二张
	 * 重定向所做的操作是带着原本的response去重新call重定向的路径，界面显示的路径会改变。
	 * 
	 * @return
	 */
	@RequestMapping(value="redirectToHello", method = RequestMethod.GET)
	public String rediectToIndex(){
		// Do somethong here
		//这里的重定向是重新去call "/hello"这个requestMapping，下面两个请求，界面的文字不一样
		//并且会发现界面中的请求路径改变了,所以"redirect:/index"并不会显示index.jsp
		//return "redirect:/index";
		//return "redirect:/hello";
		return "redirect:/helloWorld";
	}
	
	@RequestMapping(value="redirectWithHSR", method = RequestMethod.GET)
	public void redirect(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//重定向方法只能将请求转发到同一Web站点的其它组件
		resp.sendRedirect("/mymvc/helloWorld");
	}
	
	/**
	 * 请求转发就高级了很多，除了可以实现重定向的功能
	 * 另外： 而且可以仅用绝对的URL地址重定向到别的站点
	 * 区别 ： 1.用绝对的URL地址重定向到别的站点
	 * 		2.界面显示的请求路径没有变化
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="forwardWithHSR", method = RequestMethod.GET)
	public void forward(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//可以对req进行操作，例如加一些参数,并且发现请求路径没有变化.
		//而且可以仅用绝对的URL 地址重定向到别的站点
		req.getRequestDispatcher("/hello").forward(req, resp);
		return ;
	}
	
	
	
}
