package com.spring3.common.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijiyun
 * @date 2024/06/16 18:56
 */
@Configuration
@ConditionalOnProperty(prefix = "swagger", name = "enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI(SwaggerProperties swaggerProperties) {
        return new OpenAPI()
                .info(new Info()
                        .title(swaggerProperties.getTitle())
                        .description(swaggerProperties.getDescription())
                        .license(new License().name(swaggerProperties.getLicense())).termsOfService(swaggerProperties.getServiceUrl())
                        .contact(new Contact()
                                .name(swaggerProperties.getContactName())
                                .url(swaggerProperties.getContactUrl())
                                .email(swaggerProperties.getContactEmail()))
                        .version(swaggerProperties.getVersion()));
    }
}
