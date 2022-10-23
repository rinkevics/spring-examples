package lv.kingfisher.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("db")
public class DBController {

    @Autowired
    public DBBean dbBean;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("attr", "controller/" + dbBean.method());
        return "test";
    }

}
