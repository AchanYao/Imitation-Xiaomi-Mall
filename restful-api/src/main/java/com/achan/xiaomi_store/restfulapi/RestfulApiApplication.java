package com.achan.xiaomi_store.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestfulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class, args);
    }

}
