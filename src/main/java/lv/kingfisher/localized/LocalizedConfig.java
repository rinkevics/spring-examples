package lv.kingfisher.localized;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class LocalizedConfig {

    @Bean
    public static ResourceBundleMessageSource getMessageSource() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/label");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
