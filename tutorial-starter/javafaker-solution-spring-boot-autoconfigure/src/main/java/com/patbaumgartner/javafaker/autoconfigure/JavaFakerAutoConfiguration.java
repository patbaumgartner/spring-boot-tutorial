package com.patbaumgartner.javafaker.autoconfigure;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.github.javafaker.Faker;

@Configuration
@ConditionalOnClass(Faker.class)
@EnableConfigurationProperties(JavaFakerProperties.class)
public class JavaFakerAutoConfiguration {

	@Autowired
	private JavaFakerProperties fakerProperties;

	@Bean
	@ConditionalOnMissingBean
	public Faker faker() {

		if (!StringUtils.isEmpty(fakerProperties.getLocale())) {
			return Faker.instance(new Locale(fakerProperties.getLocale()));
		}

		if (!StringUtils.isEmpty(fakerProperties.getLanguage())) {
			return Faker.instance(new Locale(fakerProperties.getLanguage()));
		}

		return Faker.instance();

	}
}
