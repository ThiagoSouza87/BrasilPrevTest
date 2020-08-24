package br.com.brasilprev.brasilprevteste.controller;

import br.com.brasilprev.brasilprevteste.exceptions.ResourceNotFoundException;
import br.com.brasilprev.brasilprevteste.model.Customer;
import br.com.brasilprev.brasilprevteste.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Api(value="API REST Customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    @ApiOperation("Return all customers")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Customer> all(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Return  customer  by ID")
    ResponseEntity<?> findOne(@PathVariable long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if( ! customer.isPresent()) {
            throw  new ResourceNotFoundException("Could not find customer : " + id);
        }
        return new ResponseEntity<>( customer , HttpStatus.OK ) ;
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a customer")
    Customer updateCustomer(@RequestBody Customer newCustomer , @PathVariable long id){
        return customerRepository.findById(id)
        .map(customer -> {
            customer.setName(newCustomer.getName());
            customer.setSocialSecurity(newCustomer.getSocialSecurity());
            return customerRepository.save(customer);
        })
        .orElseGet(() -> {
            newCustomer.setId(id);
            return customerRepository.save(newCustomer);
        });
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a customer by ID")
    void deleteCustomer(@PathVariable long id){
        customerRepository.deleteById(id);
    }
}
