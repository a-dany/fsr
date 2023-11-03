package com.lip6._config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lip6.endpoints.ContactController;

@Configuration @EnableWebMvc
@ComponentScan(basePackages = "com.lip6")
public class AppConfig extends ResourceConfig
{
    public AppConfig() {
        this.register(ContactController.class);
    }
}
