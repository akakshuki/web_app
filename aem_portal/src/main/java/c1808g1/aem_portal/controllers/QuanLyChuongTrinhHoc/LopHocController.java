package c1808g1.aem_portal.controllers.QuanLyChuongTrinhHoc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import c1808g1.aem_portal.common.danhMucDungChung;

@Controller
@RequestMapping("/LopHoc")
public class LopHocController {
    String pathView=danhMucDungChung.PATH_ADMIN_VIEW+"LopHoc/";
    //Index
    @RequestMapping("/Index")
	public String index(Model model,@RequestParam(defaultValue = "Menu")String ajaxLoad,@RequestParam(required = false)Integer page) {
		return pathView+"index";
    }
    @RequestMapping("/AddOrUpdate")
    public String save(Model model) {
		return "index";
    }
}
