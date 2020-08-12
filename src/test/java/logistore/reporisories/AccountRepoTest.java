package logistore.reporisories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import logistore.model.Account;
import logistore.repositories.AccountRepo;

@ActiveProfiles("test")
@DataJpaTest(showSql = true)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.datasource.initialization-mode=never"
})
@EntityScan(basePackages = "logistore.model")
public class AccountRepoTest {
	
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private AccountRepo accountRepo;
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
    	final Account account = new Account();
    	account.setName("Mr. Test");
    	account.setPassword("mrtest123");
    	
        entityManager.persist(account);
        entityManager.flush();
     
        // when
        Optional<Account> accountOptional = accountRepo.findByName(account.getName());
     
        // then
        assertTrue(accountOptional.isPresent());
        assertEquals(account.getName(), account.getName());
    }
 
}
