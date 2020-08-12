package logistore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import logistore.repositories.AccountRepo;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AccountRepo accountRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		accountRepo.findAll().forEach(
				player -> System.out.println(String.format("name=%s	password=%s",
						player.getName(), player.getPassword())));
	}
}