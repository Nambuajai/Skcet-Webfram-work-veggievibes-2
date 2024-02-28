package com.veggievibe.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class productDetilas {
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fruits;
    private String dairy;
    private String vegatable;
    @ManyToOne
    private AddtoCarts add;
    
    
}
