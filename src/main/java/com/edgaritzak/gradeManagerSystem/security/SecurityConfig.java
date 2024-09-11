package com.edgaritzak.gradeManagerSystem.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
                .requestMatchers("/student/").hasRole("STUDENT")
                .requestMatchers("/student/**").hasRole("STUDENT")
                .requestMatchers("/teacher/").hasRole("TEACHER")
                .requestMatchers("/teacher/**").hasRole("TEACHER")
                .anyRequest().authenticated()
            );
        
        http.httpBasic(Customizer.withDefaults())
        
        .formLogin(formLogin ->
        formLogin
            .loginPage("/login")
            .permitAll()
        )
        .logout(logout -> 
        logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
        )
        .sessionManagement(sessionManagement ->
        sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Otras opciones: NEVER, ALWAYS, STATELESS
        )
        .csrf(csrf -> csrf.disable())
        ;
        
        return http.build();
    }
}
