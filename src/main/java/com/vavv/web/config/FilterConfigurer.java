package com.vavv.web.config;

import com.vavv.web.filter.JwtCheckFilter;
import com.vavv.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfigurer{


    @Value("${jwt.encode.param}")
    private String jwtEncryptSecret;

    @Autowired
    public UserRepository userRepository;

    @Bean
    public FilterRegistrationBean greetingFilterRegistrationBean() {
        System.out.println("\n********** Registering JwtCheckFilter ***********\n");
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("JwtCheckFilter");
        JwtCheckFilter jwtCheckFilter = new JwtCheckFilter();
        jwtCheckFilter.setJwtEncryptSecret(jwtEncryptSecret);
        jwtCheckFilter.setUserRepository(userRepository);
        registrationBean.setFilter(jwtCheckFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    /*@Bean
    public FilterRegistrationBean helloFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("hello");
        HelloFilter helloFilter = new HelloFilter();
        registrationBean.setFilter(helloFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }*/

}
