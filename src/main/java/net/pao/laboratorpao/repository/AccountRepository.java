package net.pao.laboratorpao.repository;

import net.pao.laboratorpao.model.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    // SELECT * FROM accounts WHERE accounts.balance > 100
    @Query("SELECT ac FROM Account ac WHERE ac.balance > :value")
    List<Account> findAllWhereBalanceGreater(BigDecimal value, Pageable pageable, Sort sort);

    // SELECT * FROM accounts WHERE account.id = '' OR account.id = '' .... -> NU E BUN!
    // SELECT * FROM accounts WHERE account.id IN ('',.....,'') --> ASA DA!
    List<Account> findAccountsByAccountIdEndingWithAndBalance(UUID ending, BigDecimal balance);

}
