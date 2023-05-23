package net.pao.laboratorpao.model.controller;

import net.pao.laboratorpao.model.Account;
import net.pao.laboratorpao.model.AccountDto;
import net.pao.laboratorpao.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account-id/{id}") //http://localhost:8080/api/accounts/account-id/{id}
    public Optional<Account> getById(@PathVariable(name = "id") UUID id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/accounts") // http://localhost:8080/api/accounts/accounts
    public List<Account> getAllAcounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/account-greater/{value}") // http://localhost:8080/api/accounts/account-greater/{value}
    public List<Account> getAccountsGreaterValue(@PathVariable(name = "value") BigDecimal value) {
        return accountService.getAccountGreaterThanValue(value);
    }

    //@PutMapping("/")
    //@PostMapping --> creeaza o noua entitate // RequestBody
    @PostMapping("/create-object")
    public void createObject(@RequestBody Account account) {
        accountService.save(account);
    }
    //@DeleteMapping
    //@PatchMapping
}
