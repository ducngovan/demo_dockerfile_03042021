package com.cmdglobal.crud_clean.service;

import com.cmdglobal.crud_clean.exception.NotFoundException;
import com.cmdglobal.crud_clean.model.Customer;
import com.cmdglobal.crud_clean.model.dto.CustomerDto;
import com.cmdglobal.crud_clean.model.mapper.MapperCustomer;
import com.cmdglobal.crud_clean.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> showFullData() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerDto> showDataCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        for (Customer customer : customers) {
            customerDtos.add(MapperCustomer.toCustomerDto(customer));
        }

        return customerDtos;
    }

    @Override
    public CustomerDto findCustomerById(int id) {
        CustomerDto customerDto = new CustomerDto();
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customerDto = MapperCustomer.toCustomerDto(customer);
                return customerDto;
            }
        }
        throw new NotFoundException("khong tim thay doi tuong nao!");
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        return customer1;
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        Customer customer1 = findByIdCustomer(id);
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setPhone(customer.getPhone());
        customer1.setAvatar(customer.getAvatar());
        customer1.setPassword(customer.getPassword());
        customerRepository.save(customer1);
        return customer1;
    }

    public Customer findByIdCustomer(int id) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        throw new NotFoundException("khong tim thay doi tuong nao!");
    }

    @Override
    public Boolean deleteCustomer(int id) {
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                customerRepository.delete(customer);
                return true;
            }
        }
        throw new NotFoundException("khong tim thay ID can xoa!");
    }

    @Override
    public List<CustomerDto> searchByName(String key) {
        List<CustomerDto> CustomerDto_seach = new ArrayList<CustomerDto>();
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList) {
            if (customer.getName().contains(key)) {
                CustomerDto_seach.add(MapperCustomer.toCustomerDto(customer));
            }
        }
        return CustomerDto_seach;
    }
}
