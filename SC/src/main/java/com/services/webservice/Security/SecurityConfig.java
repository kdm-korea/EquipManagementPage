package com.services.webservice.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.services.webservice.service.MemberService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private MemberService memberService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 항상 통과되어야 하는 목록들
		web.ignoring().antMatchers("/static/**", "/css/**", "/img/**", "/js/**", "/css/lib/**", "/js/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// 페이지 권한설정
//				.antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/user/myinfo").hasRole("MEMBER")
				.antMatchers("/**").permitAll().antMatchers("/h2").permitAll().and().formLogin().loginPage("/")
				.usernameParameter("loginStudentNum").passwordParameter("loginPassword")

				.defaultSuccessUrl("/user/chooseEuqip").failureUrl("/").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/")
				.invalidateHttpSession(true).and().exceptionHandling().accessDeniedPage("/user/denied");

		http.csrf().disable();

		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}
}