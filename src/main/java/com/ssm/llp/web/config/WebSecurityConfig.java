package com.ssm.llp.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 * http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeUrls()
                .antMatchers("/home", "/signup", "/about").permitAll()
                .antMatchers("/secure/**").hasRole("ADMIN") // drop ROLE_
                .antMatchers("/secure/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginUrl("/login")
                .permitAll();
    }
}
