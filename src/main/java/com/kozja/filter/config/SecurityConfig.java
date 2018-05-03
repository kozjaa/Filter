
package com.kozja.filter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity security) throws Exception
    {
        security.authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .antMatchers("/clients/**").hasRole("ADMIN").anyRequest().authenticated().and()
                .formLogin().defaultSuccessUrl("/clients");
    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception
    {
        BCryptPasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("admin1").password(encoder.encode("admin1")).roles("ADMIN")
                .and().withUser("user1").password(encoder.encode("user1")).roles("USER");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

