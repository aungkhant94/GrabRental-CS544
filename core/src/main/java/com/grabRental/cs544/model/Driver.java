package com.grabRental.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue
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

    public Driver(String firstName, String lastname, Integer age, String address, String licenseId, Integer experience) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
        this.licenseId = licenseId;
        this.experience = experience;
    }


}
