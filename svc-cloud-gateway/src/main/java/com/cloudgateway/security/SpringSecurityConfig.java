package com.cloudgateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig  {

	@Autowired
	private JwtAuthenticationFilter autenticationFilter;
	
	
	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
		return http.authorizeExchange()
				.pathMatchers("/api/security/oauth/**").permitAll()
				.pathMatchers(HttpMethod.GET, "/api/usuarios/usuarios/{userName}").permitAll()
				//.pathMatchers(HttpMethod.GET, "/api/usuarios/{id}").hasAnyRole("ADMIN", "USER")
				//.pathMatchers("/api/usuarios/**","/api/clientes/**").hasRole("ADMIN")
				.anyExchange().authenticated()
				.and().addFilterAt(autenticationFilter,SecurityWebFiltersOrder.AUTHENTICATION)
				.csrf().disable()
				.build();
	}
	
}
