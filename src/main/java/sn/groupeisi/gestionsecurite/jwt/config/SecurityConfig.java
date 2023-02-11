package sn.groupeisi.gestionsecurite.jwt.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sn.groupeisi.gestionsecurite.dtos.AppUser;
import sn.groupeisi.gestionsecurite.jwt.filters.JwtAuthenticationFilter;
import sn.groupeisi.gestionsecurite.jwt.filters.JwtAuthorizatrionFilter;
import sn.groupeisi.gestionsecurite.services.IAppUserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private IAppUserService appUserService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				
				AppUser appUser = appUserService.loadUserByEmail(email);
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				appUser.getRoles().forEach(role->{
					authorities.add(new SimpleGrantedAuthority(role.getName()));
				});
				return new User(appUser.getEmail(), appUser.getPassword(), authorities);
			}
		});
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.formLogin();
		//http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ADMIN");
		//http.authorizeRequests().antMatchers("/user/save").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizatrionFilter(), UsernamePasswordAuthenticationFilter.class);
//		http.authorizeRequests().antMatchers("/acceuil").hasAnyAuthority("ADMIN");
//		http.authorizeRequests().antMatchers("/menu").hasAnyAuthority("USER", "ADMIN");
	}

	// Used by spring security if CORS is enabled.
	@Bean
	public CorsFilter corsFilter() {

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOriginPatterns(Collections.singletonList("*"));
		config.setAllowedHeaders(
				Arrays.asList("Origin", "Content-Type", "Accept", "responseType", "Authorization"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

}
