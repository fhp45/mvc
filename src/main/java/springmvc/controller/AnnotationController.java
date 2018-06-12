package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.pojo.User;

@Controller
public class AnnotationController {
	
	/**
	 * --@RequestParam的例子，请求的路径是http://localhost:8080/mymvc/requestParam?name=hepei&age=25
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("requestParam")
	public ModelAndView requestParamDemo(@RequestParam String name,@RequestParam String age) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("age", age);
		
		mav.setViewName("annotation");
		return mav;
	}
	
	@RequestMapping(value = "requestBody", method = RequestMethod.POST)
	public ModelAndView requestParamDemo(@RequestBody User user) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", user.getName());
		mav.addObject("password", user.getPassword());
		
		mav.setViewName("annotation");
		return mav;
	}
	
	@RequestMapping("ajax")
	public ModelAndView ajaxDemo() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("ajax");
		return mav;
	}
	
	
}
