package com.turkcell.TechnicalService.core.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turkcell.TechnicalService.dao.SystemUserDao;
import com.turkcell.TechnicalService.model.Role;
import com.turkcell.TechnicalService.service.abstracts.SystemUserService;
import com.turkcell.TechnicalService.service.concretes.SystemUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turkcell.TechnicalService.model.SystemUser;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{


	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager)
	{
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException
	{
		try
		{
			SystemUser creds = new ObjectMapper().readValue(req.getInputStream(), SystemUser.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getName(), creds.getPassword(),new ArrayList<>()));
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException
	{
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().flush();
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException
	{
		// MY_SECRET_KEY önemli
		User principal = ((User) auth.getPrincipal());
		String rolestring = principal.getAuthorities().toArray()[0].toString();
		String str = principal.getUsername() + "-" + rolestring;
		String token = JWT.create().withSubject(str).withExpiresAt(new Date(System.currentTimeMillis() + 900000)).sign(Algorithm.HMAC512("MY_SECRET_KEY".getBytes()));
		// body = (recep) 30948hgb57gbhg9wpuısgh==
		String body = principal.getUsername() + "-" + token;
		res.getWriter().write(body);
		res.getWriter().flush();
	}
}