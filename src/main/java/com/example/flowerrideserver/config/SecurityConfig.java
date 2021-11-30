package com.example.flowerrideserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers("/delete-user/*").hasRole("ADMIN")
                .antMatchers("/update-user").hasRole("ADMIN")
                .antMatchers("/add-warehouse-state").hasRole("USER")
                .antMatchers("/delete-warehouse-state/*").hasRole("USER")
                .antMatchers("/update-warehouse-state").hasRole("USER")
                .antMatchers("/warehouse-states").permitAll()
                .and().csrf().disable();
    }
}