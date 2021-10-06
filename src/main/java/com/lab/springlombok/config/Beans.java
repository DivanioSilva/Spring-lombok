package com.lab.springlombok.config;

import com.lab.springlombok.exceptions.ExceptionsBag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public ExceptionsBag exceptionsBag(){
        return new ExceptionsBag();
    }
}
