package c1808g1.aem_portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class MainController {
	@RequestMapping("")
	public String main(Model model) {
		return "demo";
	}
}
