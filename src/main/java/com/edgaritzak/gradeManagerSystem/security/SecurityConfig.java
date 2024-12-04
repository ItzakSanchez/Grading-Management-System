package com.edgaritzak.gradeManagerSystem.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.edgaritzak.gradeManagerSystem.entity.SystemUser;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

import jakarta.annotation.PostConstruct;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private SystemUserServiceImpl systemUserServiceImpl;
    private final InMemoryUserDetailsManager userDetailsManager;

    public SecurityConfig() {
        this.userDetailsManager = new InMemoryUserDetailsManager();
    }
	
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return userDetailsManager;
    }
    //ADD USERS 
    @PostConstruct
    public void initializeUsers() {
        updateUsers();
    }
    
    public void updateUsers() {
        List<UserDetails> userList = systemUserServiceImpl.findAll()
            .stream()
            .map(x -> User.builder()
                .username(x.getEmail())
                .password("{noop}" + x.getPassword())
                .roles(x.getRole())
                .build())
            .collect(Collectors.toList());
                
        userList.forEach((user) -> userDetailsManager.createUser(user));
    }
    //REMOVE USERS
    public void removeUsers() {
        List<SystemUser> userList = systemUserServiceImpl.findAll();
        userList.forEach((user) -> userDetailsManager.deleteUser(user.getEmail()));
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
                .requestMatchers("/admin/").hasRole("ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated());
        
        http.httpBasic(Customizer.withDefaults())
        .formLogin(formLogin ->
        formLogin
            .loginPage("/login")
            .defaultSuccessUrl("/auth", true)
            .permitAll())
        	.logout(logout -> 
			    logout
			        .logoutUrl("/logout")
			        .logoutSuccessUrl("/login?logout")
			        .clearAuthentication(true)
			        .deleteCookies("JSESSIONID")
			        .invalidateHttpSession(true)
			        .permitAll())
			    .sessionManagement(sessionManagement ->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
			    .csrf(csrf -> csrf.disable());
        
        return http.build();
    }
}
