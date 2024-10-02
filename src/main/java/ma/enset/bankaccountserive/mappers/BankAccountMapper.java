package ma.enset.bankaccountserive.mappers;
import ma.enset.bankaccountserive.dto.BankAccountRequestDTO;
import ma.enset.bankaccountserive.dto.BankAccountResponseDTO;
import ma.enset.bankaccountserive.entities.BankAccount;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@Component
public class BankAccountMapper {

    public static BankAccount toEntity(BankAccountRequestDTO bankAccountRequestDTO) {
        return BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(bankAccountRequestDTO.getType())
                .build();
    }

    public static BankAccountResponseDTO toResponseDTO(BankAccount bankAccount) {
        return BankAccountResponseDTO.builder()
                .id(bankAccount.getId())
                .balance(bankAccount.getBalance())
                .createdAt(bankAccount.getCreatedAt())
                .currency(bankAccount.getCurrency())
                .type(bankAccount.getType())
                .build();
        /*
        * BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        * BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO )
        * */
    }
}
