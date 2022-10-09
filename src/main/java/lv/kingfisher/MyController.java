package lv.kingfisher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class MyController {

    @GetMapping
    public String get(Model model) {
        model.addAttribute("attr", "from servlet");
        return "test";
    }

}
