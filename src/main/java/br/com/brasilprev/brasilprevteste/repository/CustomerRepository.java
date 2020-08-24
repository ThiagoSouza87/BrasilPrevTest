package br.com.brasilprev.brasilprevteste.repository;

import br.com.brasilprev.brasilprevteste.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CustomerRepository extends JpaRepository<Customer , Long> {

}
