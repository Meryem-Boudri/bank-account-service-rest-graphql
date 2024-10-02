package ma.enset.bankaccountserive.service;

import ma.enset.bankaccountserive.enums.AccountType;
import ma.enset.bankaccountserive.mappers.BankAccountMapper;
import ma.enset.bankaccountserive.dto.BankAccountRequestDTO;
import ma.enset.bankaccountserive.dto.BankAccountResponseDTO;
import ma.enset.bankaccountserive.entities.BankAccount;
import ma.enset.bankaccountserive.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccountMapper.toEntity(bankAccountRequestDTO);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        return BankAccountMapper.toResponseDTO(savedBankAccount);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id ,BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Account not found with id %s", id))
        );
        // Use BankAccountMapper to update fields selectively
        if (bankAccountRequestDTO.getBalance() != null) {
            bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        }
        if (bankAccountRequestDTO.getType() != null) {
            bankAccount.setType(bankAccountRequestDTO.getType());
        }
        if (bankAccountRequestDTO.getCurrency() != null) {
            bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        }
        bankAccountRepository.save(bankAccount);

        return BankAccountMapper.toResponseDTO(bankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public BankAccountResponseDTO getAccount(String id) {
        BankAccount bankAccount= bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account not found with id %s", id)));
        return BankAccountMapper.toResponseDTO(bankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> getAccounts() {

        return bankAccountRepository
                .findAll()
                .stream()
                .map(BankAccountMapper::toResponseDTO).toList();
    }

    @Override
    public List<BankAccountResponseDTO> getAccountsByType(AccountType type) {

        return bankAccountRepository
                .findAll()
                .stream()
                .filter(e -> e.getType() == type)
                .map(BankAccountMapper::toResponseDTO).toList();
    }
}
