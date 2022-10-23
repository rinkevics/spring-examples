package lv.kingfisher.localized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("local")
public class LocalizedController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @GetMapping
    public String get(Model model) {
        var message = "<br/>en " + messageSource.getMessage("name", new Object[]{"John"}, Locale.getDefault());
        message += "<br/>lv " + messageSource.getMessage("name", new Object[]{"John"}, new Locale("lv"));

        model.addAttribute("attr", "controller/" + message);
        return "test";
    }

}
