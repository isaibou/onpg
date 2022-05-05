package com.example.demo.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

	
	  @Autowired
	  PasswordEncoder encoder;
	 
	  @Autowired
	  DataSource dataSource;
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws  Exception { 
	   auth.jdbcAuthentication()
	  .passwordEncoder(encoder)
	  .usersByUsernameQuery("select email as principal, mdp as credentials, actived from users where email =?"
	  )
	  
	  .authoritiesByUsernameQuery("select users_email as principal, roles_role as role from users_roles where users_email =?"
	  ) .rolePrefix("ROLE_") .dataSource(dataSource); }
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/test/**","/css/**","/images/**","/js/**","/libs/**","/fonts/**","/src/**","/forgetPassword","/privacy","/resetPassword",
				"/inscriptionS","/inscrire","/presentation","/inscriptionO/",
				"/publication","/membres","/inscriptionO","/insO","/insO2","/login1","/role","/saveUsers","/index","/index1","/viewPublication","/viewTexte","/saveContact","/addInscrip",
				"/addInscrip2","/saveMessage","/paiement","/addP","/pdf").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login1")
		.successForwardUrl("/index")
		.permitAll()
		
		.and()
		.logout()
		.logoutUrl("/LoginVrai?logout")
		.logoutSuccessUrl("/LoginVrai")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID");
	}
}
