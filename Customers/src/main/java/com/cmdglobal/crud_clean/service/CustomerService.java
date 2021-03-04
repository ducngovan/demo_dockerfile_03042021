package com.cmdglobal.crud_clean.service;

import com.cmdglobal.crud_clean.model.Customer;
import com.cmdglobal.crud_clean.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> showFullData();

    List<CustomerDto> showDataCustomer();

    CustomerDto findCustomerById(int id);

    Customer addCustomer(Customer customer );

    Customer updateCustomer(Customer customer, int id);

    Boolean deleteCustomer(int id);

    List<CustomerDto> searchByName(String key);


}
