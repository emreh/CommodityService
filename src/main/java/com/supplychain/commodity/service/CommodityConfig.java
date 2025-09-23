package com.supplychain.commodity.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import lombok.RequiredArgsConstructor;

@Configuration
@ComponentScan(basePackages = {"com.supplychain.commodity.service"})
@EnableTransactionManagement
@EntityScan("com.supplychain.commodity.service.persistence.model")
@EnableJpaRepositories("com.supplychain.commodity.service.persistence.repository")
@RequiredArgsConstructor
public class CommodityConfig {

    @Bean
    MessageSource messageSourceRepository() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

	messageSource.setBasenames("classpath:i18n/message/messages, classpath:i18n/enums/enumeration");
	messageSource.setDefaultEncoding("UTF-8");

	return messageSource;
    }

    @Bean
    LocalValidatorFactoryBean getValidatorRepository() {
	LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	bean.setValidationMessageSource(messageSourceRepository());
	return bean;
    }
}
