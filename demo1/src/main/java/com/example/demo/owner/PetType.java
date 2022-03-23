package org.springframework.example.demo.owner;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.example.demo.model.NamedEntity;

@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

}