package logistore.config;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "logistore.repositories" })
public class JpaConfig {

	@Bean
	public PhysicalNamingStrategy physical() {
		return new CustomPhysicalNamingStrategy();
	}

}
