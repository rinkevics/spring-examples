package org.kaspars;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.kaspars" })
public class WebConfig implements WebMvcConfigurer {

    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/jsp/").suffix(".jsp");
    }

}