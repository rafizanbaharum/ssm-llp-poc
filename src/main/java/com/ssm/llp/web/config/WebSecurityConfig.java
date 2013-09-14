package com.ssm.llp.web.config;

import com.ssm.llp.integration.springsecurity.SsmUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 *        http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**"); // #3
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeUrls()
                .antMatchers("/index", "/gate", "/about").permitAll()
                .antMatchers("/secure/**").hasRole("ADMIN") // drop ROLE_
                .antMatchers("/secure/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginUrl("/login")
                .defaultSuccessUrl("/secure/dashboard")
                .failureUrl("/gate?login_error=1")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return new SsmUserDetailService();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return new AuthenticationManagerBuilder()
                .userDetailsService(userDetailsServiceBean())
                .passwordEncoder(new ShaPasswordEncoder())
                .and().build();
    }
}
