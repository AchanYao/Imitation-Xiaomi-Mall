package com.achan.xiaomi_store.dao;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Achan
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.achan.xiaomi_store.dao")
@EntityScan("com.achan.xiaomi_store.model.jpa")
public class DaoApplication {

}
