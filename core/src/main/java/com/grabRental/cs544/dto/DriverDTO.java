package com.grabRental.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Long id;
    private String firstName;
    private String lastname;
    private Integer age;
    private String address;
    private String licenseId;
    private Integer experience;

}
