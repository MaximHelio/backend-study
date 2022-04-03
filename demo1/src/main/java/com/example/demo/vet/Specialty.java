package com.example.demo.vet

import javax.persistence.Entity
import javax.persistence.Table

import com.example.demo.model.NamedEntity


@Entity
@Table(name="specialties")
public class Specialty extends NamedEntity {

}