package lv.kingfisher.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("valid")
public class ValidController {

    @GetMapping
    public String get(Model model) {
        var object = new ShoppingCart();
        object.userName = "name";
        model.addAttribute("shoppingCart", object);
        return "validate";
    }

    @PostMapping
    public String submitForm(
            @Validated ShoppingCart object,
            BindingResult result,
            Model m) {
        result.addError(new ObjectError("shoppingCart", "custom message"));
        m.addAttribute("shoppingCart", object);
        return "validate";
    }


}
