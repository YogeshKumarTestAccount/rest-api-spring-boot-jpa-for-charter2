package com.charter.springboot;
/*
 * 
 *Developed By 
 *Yogesh Kumar
 *9 Sept 2017
 * 
 * 
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Set;

import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// For Custome API Docs
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/topics.*"));
	}

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(customRequestHandlers()).build();
	}

	// Filter API Methods
	private Predicate<RequestHandler> customRequestHandlers() {
		return new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				Set<RequestMethod> methods = input.getRequestMapping().getMethodsCondition().getMethods();
				return methods.contains(RequestMethod.GET) || methods.contains(RequestMethod.POST)
						|| methods.contains(RequestMethod.PUT) || methods.contains(RequestMethod.DELETE);
			}
		};
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CHARTER API DOCS").description("Charter OSM API reference for developers")
				.termsOfServiceUrl("https://www.capgemini.com").contact("Capgemini India Pvt.Ltd.")
				.license("Capgemini License").licenseUrl("https://www.capgemini.com/terms-of-use/").version("2.0")
				.build();
	}

}