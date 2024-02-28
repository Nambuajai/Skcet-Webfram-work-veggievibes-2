package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veggievibe.backend.model.AddtoCarts;

public interface AddtoCartsRepo extends JpaRepository<AddtoCarts,Integer> {
    
}
