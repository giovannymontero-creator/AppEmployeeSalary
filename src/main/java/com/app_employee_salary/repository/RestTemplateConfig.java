package com.app_employee_salary.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

	@Bean("empleadoRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
