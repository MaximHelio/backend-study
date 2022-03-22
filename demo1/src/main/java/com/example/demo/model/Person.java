package com.example.demo.model

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name="first_name")
    @NotEmpty
    private String firstName;

    @Column(name="last_name")
    @NotEmpty
    private String lastName;


    private String getFirstName(){
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}