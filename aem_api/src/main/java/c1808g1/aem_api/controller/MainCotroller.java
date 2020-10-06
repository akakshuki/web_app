package c1808g1.aem_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
public class MainCotroller {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main() {
        return "Hello";
    }
}
