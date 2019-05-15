package io.fdlessard.codebites.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {


    private CustomerGateway customerService;

    public CustomerController(CustomerGateway customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        log.info("CustomerController.isAlive()");
        return "Hello World from CustomerController";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Customer get(@PathVariable long id) {
        log.info("CustomerController.get({})", id);
        return customerService.getCustomerById(id);
    }

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public Iterable<Customer> getAll() {
        log.info("CustomerController.getAll()");
        return customerService.geAllCustomers();
    }
}