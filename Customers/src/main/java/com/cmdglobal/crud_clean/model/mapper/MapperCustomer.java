package com.cmdglobal.crud_clean.model.mapper;

import com.cmdglobal.crud_clean.model.Customer;
import com.cmdglobal.crud_clean.model.dto.CustomerDto;

public class MapperCustomer {
    public static CustomerDto toCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setAvatar(customer.getAvatar());
        return customerDto;
    }
}
