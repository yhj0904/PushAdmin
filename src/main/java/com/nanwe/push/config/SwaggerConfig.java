package com.nanwe.push.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger (OpenAPI 3.0) 설정 클래스
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Push API 관리자")
                        .description("푸시 관리자 API 명세서")
                        .version("v1.0"));
    }
}
// Swagger 접속 경로 : http://localhost:8080/swagger-ui/index.html