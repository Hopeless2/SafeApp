package com.example.safeapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("1").password("{noop}1").authorities("read", "write")
                .and()
                .withUser("2").password("{noop}2").authorities("read")
                .and()
                .withUser("3").password("{noop}3").authorities("login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello").permitAll()
                .and()
                .authorizeRequests().antMatchers("/secret-data").hasAuthority("write")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
