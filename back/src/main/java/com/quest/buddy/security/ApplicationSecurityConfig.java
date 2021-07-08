package com.quest.buddy.security;

import static com.quest.buddy.security.ApplicationUserRole.ADMIN;
import static com.quest.buddy.security.ApplicationUserRole.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/", "login", "logout", "/static/**", "/dist/**", "/plugins/**", "/img/**","/css/**", "/js/**", "/plugin/**", "/build/**").permitAll()
        .antMatchers("/backoffice/*").hasRole(ADMIN.name())
        .anyRequest().authenticated().and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails tortevois = User.builder().username("romain").password(passwordEncoder.encode("romain"))
                .roles(USER.name()).build();

        UserDetails benjamin = User.builder().username("benjamin").password(passwordEncoder.encode("benjamin"))
                .roles(ADMIN.name()).build();
        return new InMemoryUserDetailsManager(tortevois);
    }
}
