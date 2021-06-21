package com.udacity.jdnd.course1.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Permit all requests to the /order page, as well as to all
        // files in our /css and /js directories.
        //Allow authenticated requests to any pages not specifically
        // identified.
        http.authorizeRequests()
                .antMatchers("/order", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        //Allow unauthenticated users to access the
        // automatically-generated login page at /login
        http.formLogin()
                .loginPage("/login")
                .permitAll();

        //Redirect users to the /tacos page once they’re logged in,
        // so they can immediately pick out which delicious tacos to buy.
        http.formLogin()
                .defaultSuccessUrl("/tacos", true);
    }
}
