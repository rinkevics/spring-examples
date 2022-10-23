package lv.kingfisher.prop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("prop")
public class PropController {

    @Value("${prop1}")
    private String prop;

    @Autowired
    private Environment env;

    @GetMapping
    public String get(Model model) {
        var result = "<br/> property source: " + prop +
                "<br/> servlet param: " + env.getProperty("contextClass") +
                "<br/> web.xml: " + env.getProperty("web-xml") +
                "<br/> system environment vars: " + env.getProperty("JAVA_HOME") +
                "<br/> app properties (-D): " + env.getProperty("catalina.base");

        model.addAttribute("attr", "controller/" + result);
        return "test";
    }

}
