package com.turkcell.TechnicalService.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.turkcell.TechnicalService.dao.SystemUserDao;
import com.turkcell.TechnicalService.service.abstracts.SystemUserService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecConfig {

	private final SystemUserService systemUserService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(systemUserService).passwordEncoder(bCryptPasswordEncoder);

		AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/user/**").permitAll().antMatchers("/login/**").permitAll()
				.antMatchers("/systemuser/save").permitAll().anyRequest()
				.authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManager))
				.addFilter(new JWTAuthorizationFilter(authenticationManager))
				.authenticationManager(authenticationManager).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}

}