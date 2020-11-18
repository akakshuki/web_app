package c1808g1.aem_portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class MainController {
	//fist test page
	@RequestMapping("")
	public String main(Model model) {
		return "admin";
	}
	//second site
	@RequestMapping("/second-page")
	//you can use Model or ModelMap are also true 
	public String main2(ModelMap model) {
		//add attribute to view is so ez
		model.put("test","this is value from controller");
		return "admin2";
	}
	//login page
	@RequestMapping("/login")
	public String Login(Model model) {
			return "admin/pages/Login/index";
	}
}
