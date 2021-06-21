package com.udacity.jwdnd.Spring_Security_Basics.config;

import com.udacity.jwdnd.Spring_Security_Basics.mapper.UserMapper;
import com.udacity.jwdnd.Spring_Security_Basics.service.AuthenticationService;
import com.udacity.jwdnd.Spring_Security_Basics.service.HashService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

//SecurityConfig: Implements the methods that modify Spring’s configuration
// to use our Services (service classes provided in the service package)

//WebSecurityConfigAdapter: Interface describing the methods that modify
// Spring’s security configuration
// In other words it lets us write an adapter for
// Spring's Web Security Configurer

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    //we inject our authentication service in the constructor
    // just like any spring bean the we add it to the authentication
    // manager builder with the authentication provider method.
    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //This function configures springs authentication manager.
    //It takes this builder class as an argument supplied by spring,
    // and it calls methods on the builder class to add and configure
    // parts of the authentication scheme for our app.
    //
    //In our case, all we need to use this for is to tell spring to
    // use our authentication service to check user logins.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }

    //FilterRegistrationBean: Object used to association filters with
    // URL patterns
    //Filter: Interface describing methods for taking action when an
    // HttpRequest is received

    //This configure method defines how spring receives authorization
    // requests, which pages it requires authorization to access,
    // and how it handles log outs.
    //
    //It does this all through the use of a complex DSL or
    // domain specific language that uses method chaining to
    // reduce the code required to set all of these conditions up.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //users attempting to go to the sign-up, CSS and JS URLs do
        // not have to log in, but users attempting to go to any
        // other URL, will.
        //It also allows authenticated users to make any kind of request.
        http.authorizeRequests()
                .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        //We can call the.formLogin method on the HTTP Security
        // object and spring will actually generate the entire
        // thing for us.
        //
        //We can supply our own HTML template and controller to
        // serve it if we want to customize the look of
        // our login form.
        http.formLogin()
                .loginPage("/login")
                .permitAll();

        // a default redirect on successful login to our home URL
        http.formLogin()
                .defaultSuccessUrl("/home", true);
    }


}
