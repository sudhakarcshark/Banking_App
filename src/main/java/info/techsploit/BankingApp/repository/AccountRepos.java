package info.techsploit.BankingApp.repository;

import info.techsploit.BankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepos extends JpaRepository<Account,Long> {
}
