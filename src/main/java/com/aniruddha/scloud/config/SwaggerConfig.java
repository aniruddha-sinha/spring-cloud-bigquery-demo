package com.aniruddha.scloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.aniruddha.scloud.controller"))
				.paths(PathSelectors.regex("/apis.*")).build().apiInfo(metaInfo());
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	private ApiInfo metaInfo() {
		final String title = "Spring Cloud BigQuery Demo APIs";
		final String description = "Demonstration of Spring Cloud GCP features: Google BigQuery";
		final String version = "1.0.0-SNAPSHOT";
        @SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(title, description, version, null, null, null, null);
        return apiInfo;
    }
}