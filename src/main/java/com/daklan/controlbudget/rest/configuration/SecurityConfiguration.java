package com.daklan.controlbudget.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/springfox-swagger-ui/**", "/v2/api-docs").permitAll()
                .antMatchers("/alive", "/inputs").permitAll()
                .anyRequest().permitAll()
                .and()
                .csrf()
                .disable();
        //.anyRequest().denyAll();
    }
}
