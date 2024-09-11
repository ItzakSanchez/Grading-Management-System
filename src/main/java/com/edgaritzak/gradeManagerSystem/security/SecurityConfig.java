package com.edgaritzak.gradeManagerSystem.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private SystemUserServiceImpl systemUserServiceImpl;
	
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

    	List<UserDetails> userList = systemUserServiceImpl.findAll()
		.stream()
    	.map(x -> User.builder()
    			.username(x.getEmail())
    			.password("{noop}"+x.getPassword())
    			.roles(x.getRole())
    			.build())
    	.collect(Collectors.toList());
        
        return new InMemoryUserDetailsManager(userList);
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                .requestMatchers("/student/**").hasRole("STUDENT")
                .requestMatchers("/student/hi").hasRole("STUDENT")
                .requestMatchers("/teacher/**").hasRole("TEACHER")
                .anyRequest().authenticated()
            )
//            .formLogin(formLogin ->
//                formLogin
//                    .loginPage("/login")
//                    .permitAll() 
//            )
//            .logout(logout ->
//                logout
//                    .permitAll()
//            )
       ;
        return http.build();
    }
}
