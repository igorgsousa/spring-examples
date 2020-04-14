package br.com.igorgsousa.main.config;

import java.util.Collections;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
		
        return new Docket(DocumentationType.SWAGGER_2)
			.produces(Collections.singleton("application/json"))
		    .consumes(Collections.singleton("application/json"))
		    .ignoredParameterTypes(Authentication.class)
		    .select()                                  
		    .apis(RequestHandlerSelectors.any())              
		    .paths(PathSelectors.any())                          
		    .build();                                           
    }
}
