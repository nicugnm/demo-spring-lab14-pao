package net.pao.laboratorpao.service;

import net.pao.laboratorpao.model.Account;
import net.pao.laboratorpao.model.AccountDto;
import net.pao.laboratorpao.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> getAccountById(UUID id) {
        Optional<Account> accounts =  accountRepository.findById(id);
        // if present!
        Account acc = accounts.get();

        AccountDto accountDto = new AccountDto(acc.getAccountId(), acc.getBalance());

        // nu se mai executa cod hibernate
        // pentru ca nu lucram pe entitate.
        accountDto.setBalance(BigDecimal.valueOf(300));

        // UPDATE accounts
        // SET balance=300
        // WHERE accountId = id;
        acc.setBalance(BigDecimal.valueOf(300));

        return accounts;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll().stream()
                .sorted()
                .toList();
    }

    public List<Account> getAccountGreaterThanValue(BigDecimal value) {
        Pageable pageable = Pageable.ofSize(10);
        Sort sort = pageable.getSort().ascending();
        return accountRepository.findAllWhereBalanceGreater(value, pageable, sort);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }
}
