package lv.kingfisher.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestScopedBean {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

    public String method() {
        return "request scoped bean";
    }

}
