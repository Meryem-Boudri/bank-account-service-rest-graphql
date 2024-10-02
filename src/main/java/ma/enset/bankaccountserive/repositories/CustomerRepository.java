package ma.enset.bankaccountserive.repositories;

import ma.enset.bankaccountserive.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
