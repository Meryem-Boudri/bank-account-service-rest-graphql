package ma.enset.bankaccountserive.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.bankaccountserive.enums.AccountType;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id ;
    private Date createdAt ;
    private Double balance ;
    private String currency ;
    private AccountType type;
}
