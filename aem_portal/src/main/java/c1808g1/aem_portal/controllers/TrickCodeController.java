package c1808g1.aem_portal.controllers;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import aem_trickcode.TrickCode;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("trickcode")
public class TrickCodeController {
	private TrickCode trickCode;

	public TrickCodeController() {
		super();
		this.trickCode = new TrickCode();
	}

	@RequestMapping(value = "getCapcha", method = RequestMethod.GET)
	public String name(Model model) {

		String capchaCode = trickCode.getCapChaWeb();

		model.addAttribute("getCapcha", capchaCode);
		return "trickcode/getCapcha";
	}

	@RequestMapping(value = "getCapcha", method = RequestMethod.POST)
	public String name(@RequestBody() String capchacode, Model model) throws IOException, JSONException {
		boolean capchaCode = trickCode.getLogin(capchacode);
		if (capchaCode) {
			System.out.println("thanh cong ");
			var data = this.trickCode.getSessionsForModule("279", "619","2682");
			data.forEach(x -> System.out.println(x.getName()));
		} else
			System.out.println("khong thanh cong");

		return "trickcode/getCapcha";
	}

}
