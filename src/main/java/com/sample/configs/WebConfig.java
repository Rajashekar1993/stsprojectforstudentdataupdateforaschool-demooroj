package com.sample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "src.main", "src.main.webapp" })
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/StudentsDataCollection/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	// =======================================
	// = Override Methods =
	// =======================================

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pdfs/**").addResourceLocations("/pdfs/");

		registry.addResourceHandler("/css/**").addResourceLocations("/css/");

		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
}
