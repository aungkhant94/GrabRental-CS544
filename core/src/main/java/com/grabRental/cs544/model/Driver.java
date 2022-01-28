package com.grabRental.cs544.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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

}
