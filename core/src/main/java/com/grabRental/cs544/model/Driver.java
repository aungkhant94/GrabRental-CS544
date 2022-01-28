package com.grabRental.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastname;
    private Integer age;
    private String address;
    private String licenseId;
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
