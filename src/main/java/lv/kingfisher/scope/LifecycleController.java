package lv.kingfisher.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lifecycle")
public class LifecycleController {

    @Autowired
    public RequestScopedBeanProxy requestScopedBeanProxy;

    @Autowired
    public ObjectProvider<RequestScopedBean> requestScopedBeanProvider;

    @GetMapping
    public String test(Model model) {
        var requestScopedBean = requestScopedBeanProvider.getIfAvailable();
        model.addAttribute("attr", "controller/ <br/>" +
                requestScopedBeanProxy.method() + "<br/> " + requestScopedBean.method());
        return "test";
    }

}
