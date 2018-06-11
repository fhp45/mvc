package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloworldController {

	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", "Hello SpringMVC");
		mav.setViewName("hello");
		return mav;
	}
	
	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("greeting", "Hello World SpringMVC");
		
		return "hello";
		
		
	}
	
	
	
}
