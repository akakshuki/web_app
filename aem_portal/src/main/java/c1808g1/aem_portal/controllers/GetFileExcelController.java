package c1808g1.aem_portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/getFileExcel")
public class GetFileExcelController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String GetFileExcelForm() {
		return "excelCode/addExcel";
	}
}
