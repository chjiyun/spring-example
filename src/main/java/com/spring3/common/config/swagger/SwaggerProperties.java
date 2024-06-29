package com.spring3.common.config.swagger;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lijiyun
 * @date 2024/06/16 18:57
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
    /**
     * 是否启用Swagger
     */
    private boolean enable;

    /**
     * 扫描的基本包
     */
    private String basePackage;

    /**
     * ApiInfo标题
     */
    private String title;

    /**
     * ApiInfo描述
     */
    private String description;

    /**
     * ApiInfo版权信息
     */
    private String license;

    /**
     * ApiInfo协议地址
     */
    private String serviceUrl;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人URL
     */
    private String contactUrl;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 版本
     */
    private String version;
}
