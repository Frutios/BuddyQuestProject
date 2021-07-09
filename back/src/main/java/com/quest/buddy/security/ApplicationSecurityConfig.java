package com.quest.buddy.security;

import static com.quest.buddy.security.ApplicationUserRole.ADMIN;
import static com.quest.buddy.security.ApplicationUserRole.USER;

import java.util.concurrent.TimeUnit;

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
        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/","/backoffice/", "login", "logout", "/static/**", "/dist/**", "/plugins/**", "/img/**","/css/**", "/js/**", "/plugin/**", "/build/**").permitAll()
        .antMatchers("/backoffice/**","/api/database/*").hasRole(ADMIN.name())
        .anyRequest().authenticated().and()
        .formLogin()
        .loginPage("/backoffice/login").permitAll()
        .defaultSuccessUrl("/backoffice/events",true)
        .and()
        .rememberMe()
        .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
        .key("trèssecurisé");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails tortevois = User.builder()
        .username("romain")
        .password(passwordEncoder
        .encode("romain"))
        .authorities(USER.grantedAuthorities())
        .build();

        UserDetails benjamin = User
        .builder()
        .username("benjamin")
        .password(passwordEncoder.encode("benjamin"))
        .authorities(ADMIN.grantedAuthorities())
        .build();

        UserDetails maria = 
        User.builder()
        .username("maria")
        .password(passwordEncoder.encode("maria"))
        .authorities(ADMIN.grantedAuthorities())
        .build();
        return new InMemoryUserDetailsManager(tortevois,benjamin,maria);
    }
}
