package logistore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/status/**").anonymous()
				.antMatchers(HttpMethod.GET, "/accounts/**").authenticated()
				.and().csrf().disable().formLogin()
				.disable();
	}
}