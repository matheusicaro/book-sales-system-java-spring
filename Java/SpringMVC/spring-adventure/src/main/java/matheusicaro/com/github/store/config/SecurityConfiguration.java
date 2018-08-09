package matheusicaro.com.github.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//@Autowired
	//privateUserDAO userDAO;
	
	@Autowired
	private UserDetailsService users;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());  
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	        .antMatchers("/products/form").hasRole("ADMIN")
	        .antMatchers("/cart/**").permitAll()        
	        .antMatchers("/products/").hasRole("ADMIN")
	        .antMatchers("/products/**").permitAll()
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/paymant/**").permitAll()
	        .antMatchers("/").permitAll()
	        .anyRequest().authenticated()
	        .and().formLogin().loginPage("/login")
	            .defaultSuccessUrl("/products").permitAll()
	        .and().logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .permitAll().logoutSuccessUrl("/login");    
	}
}
   
