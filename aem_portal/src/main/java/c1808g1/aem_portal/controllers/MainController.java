package c1808g1.aem_portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class MainController {
	@GetMapping
	@RequestMapping("/test")
	public String main(Model model) {
		return "admin";
	}
		@GetMapping
	@RequestMapping("/test1")
	public String main2(Model model) {
		model.addAttribute("test","this is value from controller");
		return "admin2";
	}

}
