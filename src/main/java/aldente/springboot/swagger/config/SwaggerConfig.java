package aldente.springboot.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.host}")
    String host;
    @Autowired
    Environment environment;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
//                .securitySchemes(Collections.singletonList(tokenAccessKey()))
//                .securityContexts(Collections.singletonList(securityContext()))
                .useDefaultResponseMessages(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("aldente.springboot.swagger"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Service")
                .description("API Service").version("1.29.28")
                .contact(new Contact("Development team", "", ""))
                .build();
    }

//    @Bean
//    SecurityScheme tokenAccessKey() {
//        return new ApiKey("JWT", "Authorization", "header");
//    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
//    }

//    private List<SecurityReference> defaultAuth() {
//        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
//        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
//    }
}
