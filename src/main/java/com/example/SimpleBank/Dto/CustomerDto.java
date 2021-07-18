package com.example.SimpleBank.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer id;

    private String name;
    private String surname;
    private Integer dateOfBirth;
    private String City;
}
