package ma.enset.bankaccountserive.web;

import ma.enset.bankaccountserive.dto.BankAccountRequestDTO;
import ma.enset.bankaccountserive.dto.BankAccountResponseDTO;
import ma.enset.bankaccountserive.entities.BankAccount;
import ma.enset.bankaccountserive.repositories.BankAccountRepository;
import ma.enset.bankaccountserive.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountService accountService;

    @QueryMapping //request de type query avec meme nom
    public List<BankAccount> accounts() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found" , id)));
    }
@MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
       try{
           accountService.deleteAccount(id);
        return true;
       } catch (Exception e) {
           return false;
       }
    }


}
