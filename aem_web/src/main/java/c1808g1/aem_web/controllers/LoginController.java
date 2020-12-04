package c1808g1.aem_web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController{
    //login page
	@RequestMapping("/login")
	public String Login(Model model) {
			return "Login/index";
	}
}

