package logistore.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import logistore.dto.AccountDTO;
import logistore.services.AccountService;

@RestController
@RequestMapping(value="/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
	
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/me")
	public AccountDTO getMe(Principal principal) {
		return accountService.getMe(principal);
	}
	
	@GetMapping("/findByNameStartsWith")
	public List<AccountDTO> findByNameStartsWith(@RequestParam("str") String str) {
		return accountService.findByNameStartsWith(str);
	}

}
