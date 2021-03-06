package com.services.webservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.services.webservice.microService.signInUp.service.UserDetailServiceImpl;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServiceImpl customUserDetail;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 항상 통과되어야 하는 목록들
		web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 페이지 권한설정
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/member/**").hasRole("MEMBER")
//				.antMatchers("/**").permitAll()
				.anyRequest().permitAll()
			.and()
				.formLogin().loginPage("/login")
//				.fail
				.usernameParameter("loginStudentNum")
				.passwordParameter("loginPassword")
//				.successHandler(successHandler)
				.defaultSuccessUrl("/member/equip")
				.failureUrl("/")
				.permitAll()
			.and()
				.logout()
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/denied");

		http.csrf().disable();

		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetail).passwordEncoder(passwordEncoder);
	}
}