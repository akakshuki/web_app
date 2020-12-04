package c1808g1.aem_web.controllers.CauHinh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import c1808g1.aem_web.common.danhMucDungChung;

@Controller
@RequestMapping("/NgayNghi")
public class NgayNghiController {
    String pathView = "NgayNghi/";

  // Index
  @RequestMapping({"","/Index"})
  public String index(Model model, @RequestParam(required = false) String ajaxLoad,
      @RequestParam(required = false) Integer page) {
    return pathView + "index";
  }
}
