package c1808g1.aem_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class MainController {
	//fist test page
	@RequestMapping({"","/Home","/"})
	public String home(Model model) {
		return "Home/index";
	}
	
}
