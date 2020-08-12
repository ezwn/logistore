package logistore;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import logistore.model.Account;
import logistore.repositories.AccountRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
	public static class User implements UserDetails {

		private static final long serialVersionUID = 1L;
		
		private Account account;
	 
	    public User(Account player) {
	        this.account = player;
	    }

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return null;
		}

		@Override
		public String getPassword() {
			return "{noop}" + account.getPassword();
		}

		@Override
		public String getUsername() {
			return account.getName();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account player) {
			this.account = player;
		}
	}
	
    @Autowired
    private AccountRepo accountRepo;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Account> accountOptional = accountRepo.findByName(username);
        if (accountOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new User(accountOptional.get());
    }

}