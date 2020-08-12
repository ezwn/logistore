package logistore.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import logistore.model.Account;
import logistore.services.AccountService;

@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {
	
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    AccountService accountService;

    @Test
    @WithMockUser(username = "me", roles={"ADMIN"})
    void getAccountMe() throws Exception {
    	final var account = new Account();
    	
    	Mockito.when(accountService.me(Mockito.any(Principal.class))).thenReturn(account);
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/me")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
