package com.example.demo.model;

import java.io.Serializable;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    pulic public boolean isNew(){
        return this.id == null;
    }
}