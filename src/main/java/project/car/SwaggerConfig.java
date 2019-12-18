package project.car;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("project.car"))
				.paths(regex("/api/v1/carros.*")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("My First Swagger API Example", "Spring Boot Swagger Example API",
				"1.0", "Terms of Service",
				new Contact("Jaime", "http://jaime.nascimento", "jaime.nascimento@mv.com.br"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html",new ArrayList<VendorExtension>() );

		return apiInfo;
	}	
}
