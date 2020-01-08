package com.achan.xiaomi_store.security;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.achan.xiaomi_store")
@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan("com.achan.xiaomi_store.security.bean")
public class SecurityApplication {

}
