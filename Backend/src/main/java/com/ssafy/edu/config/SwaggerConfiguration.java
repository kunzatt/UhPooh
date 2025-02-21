package com.ssafy.edu.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

// Swagger-UI 확인
// http://localhost/swagger-ui.html
// http://localhost:8080/uhpooh/swagger-ui.html
// DMoMJOGwHfUj/2x791wwbtXozdxwl/cvwft6sefzuNlzB8NRTRfzgQl0/tm9SHlFLalUUwmtrWa41U33H/pTEQ==
// @OpenAPIDefinition(
// info = @Info(
// title = "SSAFY Board API 명세서",
// description = "<h3>SSAFY API Reference for Developers</h3>Swagger를 이용한 Board API<br><img
// src=\"/assets/img/ssafy_logo.png\" width=\"150\">",
// version = "v1",
// contact = @Contact(
// name = "hissam",
// email = "hissam@ssafy.com",
// url = "http://edu.ssafy.com"
// )
// )
// )

@Configuration
public class SwaggerConfiguration {
    
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().title("Uhpooh")
                .description("<h3>Uhpooh API Reference for Developers</h3>Swagger를 이용한 Uhpooh API<br>")
                .version("v1").contact(new io.swagger.v3.oas.models.info.Contact().name("SSAFY")
                        .email("ssafy@ssafy.com").url("http://edu.ssafy.com"));
        
        SecurityScheme securityScheme =
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
        
        // SecurityRequirement 설정
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");
        
        
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
                .addSecurityItem(securityRequirement).info(new Info().title("API Documentation")
                        .description("<h3>SSAFY API Reference for Developers</h3>Swagger를 이용한 Uhpooh API<br>")
                        .version("v1").contact(new io.swagger.v3.oas.models.info.Contact().name("SSAFY")
                                .url("http://edu.ssafy.com")));
    }
    
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("ssafy-board").pathsToMatch("/api/**").build();
    }
    
    // @Bean
    // public GroupedOpenApi adminApi() {
    // return GroupedOpenApi.builder().group("ssafy-user").pathsToMatch("/user/**").build();
    // }
    //
    // @Bean
    // public GroupedOpenApi boardajaxApi() {
    // return GroupedOpenApi.builder().group("ssafy-board").pathsToMatch("/boardajax/**").build();
    // }
}
