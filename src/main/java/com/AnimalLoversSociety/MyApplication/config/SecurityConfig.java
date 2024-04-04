package com.AnimalLoversSociety.MyApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.AnimalLoversSociety.MyApplication.user.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users").hasAuthority("ADMIN")
                        .requestMatchers("/items/**").hasAnyAuthority("ADMIN","EMPLOYEE")
                        .requestMatchers("/employees/**").hasAuthority("ADMIN")
                        .requestMatchers("/projects/**").hasAnyAuthority("ADMIN","EMPLOYEE")
                        .requestMatchers("/donors/**").hasAnyAuthority("ADMIN","EMPLOYEE")
                        .requestMatchers("/sales/**").hasAnyAuthority("ADMIN","EMPLOYEE")
                        .requestMatchers("/seminars/**").hasAnyAuthority("ADMIN","EMPLOYEE")
                        .requestMatchers("/shop/**").hasAnyAuthority("ADMIN","EMPLOYEE","MEMBER")
                        .anyRequest().permitAll()

        )
                .formLogin(login -> login.usernameParameter("username")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }
}