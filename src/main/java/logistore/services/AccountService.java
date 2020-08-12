package logistore.services;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logistore.UserDetailsServiceImpl.User;
import logistore.dto.AccountDTO;
import logistore.model.Account;
import logistore.repositories.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public AccountDTO getMe(final Principal principal) {
		return new AccountDTO(me(principal));
	}
	
	public List<AccountDTO> findByNameStartsWith(final String playerName) {
		return accountRepo
				.findByNameStartsWithIgnoreCase(playerName)
				.stream()
				.map(player -> new AccountDTO(player)).collect(Collectors.toList());
	}

	public Account me(final Principal me) {
		if (me instanceof User)
			return ((User)me).getAccount();
		else
			return accountRepo.findByName(me.getName()).get();
	}
}
