package com.grabRental.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastname;
    @NotNull
    private Integer age;
    @NotBlank
    private String address;
    @NotBlank
    private String licenseId;
    @NotNull
    private Integer experience;

}
