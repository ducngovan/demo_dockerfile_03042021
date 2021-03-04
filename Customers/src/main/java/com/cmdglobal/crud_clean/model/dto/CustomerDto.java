package com.cmdglobal.crud_clean.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;

}
