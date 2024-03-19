/*
 * package com.AnimalLoversSociety.MyApplication.user;
 * 
 * import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails;
 * import org.springframework.security.core.userdetails.UserDetailsService;
 * import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.security.crypto.password.PasswordEncoder;
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * import org.springframework.stereotype.Service;
 * 
 * @Service
 * public class MyUserDetailsService implements UserDetailsService {
 * 
 * private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
 * 
 * @Override
 * public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * // You should fetch the user from your database here and convert it to
 * // UserDetails object
 * // For simplicity, I'm just creating a user with username "user" and password
 * // "password"
 * return User.builder()
 * .username("user")
 * .password("{bcrypt}" + passwordEncoder.encode("password"))
 * .roles("ADMIN")
 * .build();
 * }
 * 
 * }
 */