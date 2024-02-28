package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veggievibe.backend.model.productDetilas;

public interface productDetailsRepo extends JpaRepository<productDetilas,Integer> {
    
}
