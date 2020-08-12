package logistore.dto;

import java.io.Serializable;

import logistore.model.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AccountDTO
 */
@Getter
@Setter
@NoArgsConstructor
public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer accountId;

	private String name;
	
	private String password;
	
	private String email;
		
	public AccountDTO(Account account) {
		accountId = account.getAccountId();
		name = account.getName();
		email = account.getEmail();
		// password = player.getPassword();
	}

}
