package c1808g1.aem_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import aem_trickcode.module.Demo;


@Controller
public class DemoController {
	@RequestMapping("/demo")
	public String demo() {
		var user = new Demo();
		System.out.println(user.Demo112());
		return "";
	}
}
