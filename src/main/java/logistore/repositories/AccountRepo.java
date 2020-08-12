package logistore.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import logistore.model.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {

	Optional<Account> findByName(String name);
	List<Account> findByNameStartsWithIgnoreCase(String name);
}
