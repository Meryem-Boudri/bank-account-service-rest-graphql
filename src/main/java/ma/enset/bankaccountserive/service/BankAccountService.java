package ma.enset.bankaccountserive.service;

import ma.enset.bankaccountserive.dto.BankAccountRequestDTO;
import ma.enset.bankaccountserive.dto.BankAccountResponseDTO;
import ma.enset.bankaccountserive.enums.AccountType;

import java.util.List;

public interface BankAccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
    void deleteAccount(String id);
    BankAccountResponseDTO getAccount(String id);
    List<BankAccountResponseDTO> getAccounts();
    List<BankAccountResponseDTO> getAccountsByType(AccountType type);


}
