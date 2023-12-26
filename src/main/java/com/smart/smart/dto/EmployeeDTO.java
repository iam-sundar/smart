package com.smart.smart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String town;
    private String city;
    private String state;
    private String address;
}
