package com.cmdglobal.crud_clean.controller;

import com.cmdglobal.crud_clean.model.Customer;
import com.cmdglobal.crud_clean.model.dto.CustomerDto;
import com.cmdglobal.crud_clean.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("")
    public ResponseEntity<?> showFullDataCustomer() {
        List<Customer> customerList = customerService.showFullData();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/data")
    public ResponseEntity<?> showFDataCustomer() {
        List<CustomerDto> customerListDto = customerService.showDataCustomer();
        return ResponseEntity.ok(customerListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIDCustomer(@PathVariable int id) {
        CustomerDto customerDto = customerService.findCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping("")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.addCustomer(customer);
        return ResponseEntity.ok(customer1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
        Customer customer_update = customerService.updateCustomer(customer, id);
        return ResponseEntity.ok(customer_update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("xoa thanh cong");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCustomer(@RequestParam(required = false, defaultValue = "") String name) {
        List<CustomerDto> customerDtos = customerService.searchByName(name);
        return ResponseEntity.ok(customerDtos);
    }

}
