package br.com.facint.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration //componente de configuração
public class InternacionalizacaoConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource msgSource =
                new ReloadableResourceBundleMessageSource();
        msgSource.setBasenames("classpath:messages");
        msgSource.setDefaultEncoding("UTF-8");
        //msgSource.setDefaultLocale(Locale.getDefault());
        return msgSource;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
