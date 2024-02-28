package com.veggievibe.backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AddtoCarts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quality;
    @OneToMany( mappedBy = "add",cascade = CascadeType.ALL)
    private List<productDetilas> product;
    

    
}
