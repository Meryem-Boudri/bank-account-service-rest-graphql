package ma.enset.bankaccountserive.web;

import ma.enset.bankaccountserive.dto.BankAccountRequestDTO;
import ma.enset.bankaccountserive.dto.BankAccountResponseDTO;
import ma.enset.bankaccountserive.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BankAccountRestController {

@Autowired
    private BankAccountService bankAccountService;
    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> getAllAccounts() {
        return bankAccountService.getAccounts() ;
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getAccountById(@PathVariable String id) {
return bankAccountService.getAccount(id);
    }

    @PostMapping("/bankAccounts/add")
    public BankAccountResponseDTO add(@RequestBody BankAccountRequestDTO requestDTO) {
        return bankAccountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/update/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.updateAccount(id , bankAccountRequestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccountById(@PathVariable String id) {
        bankAccountService.deleteAccount(id);
    }
}
