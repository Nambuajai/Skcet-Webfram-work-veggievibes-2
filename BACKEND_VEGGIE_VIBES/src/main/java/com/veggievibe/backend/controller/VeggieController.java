package com.veggievibe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.veggievibe.backend.model.AddtoCarts;
import com.veggievibe.backend.model.DairyDetails;
import com.veggievibe.backend.model.FruitDetails;
import com.veggievibe.backend.model.VegetableDetails;
import com.veggievibe.backend.model.productDetilas;
import com.veggievibe.backend.services.VeggieServices;

@RestController
public class VeggieController {

    @Autowired
    private VeggieServices veggieServices;

    @PostMapping("/addVegetable")
    public VegetableDetails addVegetable(@RequestBody VegetableDetails vegetableDetails)
    {
        veggieServices.saveVegeteable(vegetableDetails);
        return vegetableDetails;
    }

    @PostMapping("/addFruit")
    public FruitDetails addFruit(@RequestBody FruitDetails fruitDetails)
    {
        veggieServices.saveFruits(fruitDetails);
        return fruitDetails;
    }

    @PostMapping("/addDairy")
    public DairyDetails addDairy(@RequestBody DairyDetails dairyDetails)
    {
        veggieServices.saveDairy(dairyDetails);
        return dairyDetails;
    }

    

    @GetMapping("/veggie/{id}")
    public VegetableDetails searchVeggieById(@PathVariable int id){
        return veggieServices.searchVeggieById(id);
    }

    @GetMapping("/fruite/{id}")
    public FruitDetails searchFruiteById(@PathVariable int id)
    {
        return veggieServices.searchFruiteById(id);
    }

    @GetMapping("/dairy/{id}")
    public FruitDetails searchDairyById(@PathVariable int id)
    {
        return veggieServices.searchFruiteById(id);
    }

    @GetMapping("/veggieByName/{name}")
    public ResponseEntity<List<VegetableDetails>> getVeggieByName(@PathVariable String name)
    {
        List<VegetableDetails> vegetables = veggieServices.searchVeggieByName(name);
        if(vegetables.isEmpty())
        {
            return new ResponseEntity<List<VegetableDetails>>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<List<VegetableDetails>>(vegetables, HttpStatus.OK);
        }
    } 

    @GetMapping("/fruiteByName/{name}")
    public ResponseEntity<List<FruitDetails>> getFruiteByName(@PathVariable String name)
    {
        List<FruitDetails> fruits = veggieServices.searchFruiteByName(name);
        if(fruits.isEmpty())
        {
            return new ResponseEntity<List<FruitDetails>>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<List<FruitDetails>>(fruits, HttpStatus.OK);
        }
    }

    @GetMapping("/dairyByName/{name}")
    public ResponseEntity<List<DairyDetails>> getDairyByName(@PathVariable String name)
    {
        List<DairyDetails> dairy = veggieServices.searchDairyDetails(name);
        if(dairy.isEmpty())
        {
            return new ResponseEntity<List<DairyDetails>>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<List<DairyDetails>>(dairy, HttpStatus.OK);
        }
    }

    @PutMapping("/editVeggie/{id}")
    public ResponseEntity<String> editVeggie(@PathVariable int id, @RequestBody VegetableDetails vegetableDetails)
    {
        if(veggieServices.updateVeggie(id, vegetableDetails))
        {
            return new ResponseEntity<String>("Update Successful",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Update Unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteVeggie/{id}")
    public ResponseEntity<String> deleteVeggie(@PathVariable int id)
    {
        if(veggieServices.deleteVeggie(id))
        {
            return new ResponseEntity<String>("Delete Successful",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Delete Unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteFruite/{id}")
    public ResponseEntity<String> deleteFruite(@PathVariable int id)
    {
        if(veggieServices.deleteFruite(id))
        {
            return new ResponseEntity<String>("Delete Successful", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Delete Unsuccessful", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteDairy/{id}")
    public ResponseEntity<String> deleteDairy(@PathVariable int id)
    {
        if(veggieServices.deleteDairy(id))
        {
            return new ResponseEntity<String>("Delete Successful", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Delete Unsuccessful", HttpStatus.NOT_FOUND);
        }
    }
 
    @PostMapping("/productDetails")
      public productDetilas get(@RequestBody productDetilas product)
        {
           return veggieServices.get(product);
        }

    @PostMapping("/Addtocarts")
    public AddtoCarts get(@RequestBody AddtoCarts add)
    {
        return veggieServices.get(add);
    }

    @GetMapping("/getVegetables")
    public List<VegetableDetails> getPages(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize)
    {
        return veggieServices.getPages(pageNo,pageSize);

    }
    @GetMapping("/getVegetables/sort")
    public List<VegetableDetails> getVeggie(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("sortBy") String sortBy)
    {
        return veggieServices.getSortedPages(pageNo,pageSize,sortBy);
    }

}
