package com.achan.xiaomi_store.restfulapi.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootConfiguration
public class Swagger2Config {
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("用户")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.achan.xiaomi_store.web"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("管理员")
                .apiInfo(new ApiInfoBuilder()
                        .title("商城管理员api")
                        .description("商城管理员相关操作")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.achan.xiaomi_store.admin"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("仿小米商城api")
                .description("本文档描述了仿小米商城接口定义")
                .version("1.0")
                .build();
    }
}
