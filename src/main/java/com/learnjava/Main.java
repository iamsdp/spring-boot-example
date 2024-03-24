package com.learnjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;
    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    // GET Request to get LIST
    @GetMapping
    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }

    // POST request to create a Customer
    record NewCustomerReq(
            String name,
            String email,
            Integer age
    ){}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerReq req){
        Customer newcustomer = new Customer();

        newcustomer.setName(req.name());
        newcustomer.setEmail(req.email());
        newcustomer.setAge(req.age());
        customerRepository.save(newcustomer);
    }

    // Delete Customer
    @DeleteMapping("{customerID}")
    public void deleteCustomer(@PathVariable("customerID") Integer id){
        customerRepository.deleteById(id);
    }

    // Update details, here we need to provide all the details else missing column will be set to its default value
    @PutMapping("{customerID}")
    public void updateCustomer(
            @RequestBody NewCustomerReq req,
            @PathVariable("customerID") Integer id)
    {
        Customer customer = customerRepository.findById(id).get();
        
        customer.setName(req.name());
        customer.setEmail(req.email());
        customer.setAge(req.age());

        customerRepository.save(customer);
    }

}
