package springmvc.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("pathVariable/{param1}/{param2}")
	public ModelAndView pathVariableDemo(@PathVariable Map<String,String> pathVars) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pathVariable1", pathVars.get("param1"));
		mav.addObject("pathVariable2", pathVars.get("param2"));
		
		mav.setViewName("annotation");
		return mav;
	}
	/**
	 * --@PathVariable的例子, 请求路径是http://localhost:8080/mymvc/pathVariable0/hefeng/pathVariable1/name
	 * @PathVariable中的值在路径中，@RequestMapping中{}值对应的是@PathVariable的值
	 * 
	 * @param pathVariable
	 * @param pathVariable1
	 * @return
	 */
	@RequestMapping("pathVariable0/{param1}/pathVariable1/{param2}")
	public ModelAndView pathVariableDemo1(@PathVariable String param1,@PathVariable String param2) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("param1", param1);
		mav.addObject("param2", param2);
		
		mav.setViewName("annotation");
		return mav;
	}
	
	@RequestMapping(value = "requestBody", method = RequestMethod.POST)
	public ModelAndView requestParamDemo(@RequestBody User user) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", user.getName());
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
	
	@RequestMapping("responseBody")
	@ResponseBody
	public List<User> responseBody() {
		List<User> userList = new LinkedList<User>();
		for(int i = 0 ; i < 5 ; i++) {
			User user = new User();
			user.setName("No"+ i);
			user.setPassword("password");
			userList.add(user);
		}
		return userList;
	}
	
	@RequestMapping("encodingFilter")
	@ResponseBody
	public String encodingFilter(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getCharacterEncoding());
		System.out.println(resp.getCharacterEncoding());
		return "req.getCharacterEncoding() : " + req.getCharacterEncoding() + ",CharacterEncodingFilter中的forceEncoding会影响response的编码 resp.getCharacterEncoding() : " + resp.getCharacterEncoding();
	}
	
}
