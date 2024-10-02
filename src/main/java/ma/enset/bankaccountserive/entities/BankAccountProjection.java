package ma.enset.bankaccountserive.entities;

import ma.enset.bankaccountserive.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class , name = "p1")
public interface BankAccountProjection {
    int getBalance();
    AccountType getType();
}
