package com.vivekaditya.api.rest.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.vivekaditya.api.rest")
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("/mygateapi/.*")).build().apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("MyGateApplication", "Rest API for MyGate Backend Challenge", "TOS", "Terms of service", "vivekadityapurella@gmail.com", "Apache License 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}