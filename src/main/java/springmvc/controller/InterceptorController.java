package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterceptorController {
	
	@RequestMapping("inteceptor")
	@ResponseBody
	public String interceptorDemo() {
		System.out.println("Controller method 执行了");
		return "Test Interceptor's process order.";
	}
	
}
