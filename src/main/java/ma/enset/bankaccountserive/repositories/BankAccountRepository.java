package ma.enset.bankaccountserive.repositories;

import ma.enset.bankaccountserive.entities.BankAccount;
import ma.enset.bankaccountserive.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
   @RestResource(path = "/byType")//http://localhost:8081/bankAccounts/search/byType?t=SAVING_ACCOUNT&?projection=p1 //to use a projection in find
     List<BankAccount> findByType(@Param("t") AccountType accountType);
}
