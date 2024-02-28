package com.veggievibe.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import com.veggievibe.backend.model.AddtoCarts;
import com.veggievibe.backend.model.DairyDetails;
import com.veggievibe.backend.model.FruitDetails;
import com.veggievibe.backend.model.VegetableDetails;
import com.veggievibe.backend.model.productDetilas;
import com.veggievibe.backend.repository.AddtoCartsRepo;
import com.veggievibe.backend.repository.DairyRepo;
import com.veggievibe.backend.repository.FruiteRepo;
import com.veggievibe.backend.repository.VeggieRepo;
import com.veggievibe.backend.repository.productDetailsRepo;

@Service
public class VeggieServices {
    @Autowired
    private AddtoCartsRepo addtion;
    @Autowired
    private productDetailsRepo prorepo;
    
    @Autowired
    private VeggieRepo veggieRepo;

    @Autowired
    private FruiteRepo fruiteRepo;

    @Autowired
    private DairyRepo dairyRepo;

    public VegetableDetails saveVegeteable(VegetableDetails vegetableDetails)
    {
        veggieRepo.save(vegetableDetails);
        return vegetableDetails;
    }
    public FruitDetails saveFruits(FruitDetails fruitDetails)
    {
        fruiteRepo.save(fruitDetails);
        return fruitDetails;
    }
    public DairyDetails saveDairy(DairyDetails dairyDetails)
    {
        dairyRepo.save(dairyDetails);
        return dairyDetails;
    }
    public VegetableDetails searchVeggieById(int id)
    {
        return veggieRepo.findById(id).orElse(null);
    }

    public FruitDetails searchFruiteById(int id)
    {
        return fruiteRepo.findById(id).orElse(null);
    }

    public DairyDetails searchDairyById(int id)
    {
        return dairyRepo.findById(id).orElse(null);
    }

    public List<VegetableDetails> searchVeggieByName(String name)
    {
        return veggieRepo.findByName(name);
    }

    public List<FruitDetails> searchFruiteByName(String name)
    {
        return fruiteRepo.findByName(name);
    }

    public List<DairyDetails> searchDairyDetails(String name)
    {
        return dairyRepo.findByName(name);
    }

    public Boolean updateVeggie(int id, VegetableDetails vegetableDetails)
    {
        if(this.searchVeggieById(id) == null)
            return false;
            
        try{
            veggieRepo.save(vegetableDetails);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public Boolean deleteVeggie(int id)
    {
        if(this.searchVeggieById(id) == null)
            return false;

        try{
            veggieRepo.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public Boolean deleteFruite(int id)
    {
        if(this.searchFruiteById(id) == null)
            return false;

        try{
            fruiteRepo.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public Boolean deleteDairy(int id)
    {
        if(this.searchDairyById(id) == null)
            return false;

        try{
            dairyRepo.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<VegetableDetails> SortVeggieByPriceAsc()
    {
        return veggieRepo.sortByPriceAsc();
    }

    public List<FruitDetails> SortFruiteByPriceAsc()
    {
        return fruiteRepo.sortByPriceAsc();
    }

    public List<DairyDetails> SortDairyByPriceAsc()
    {
        return dairyRepo.sortByPriceAsc();
    }

    public List<VegetableDetails> SortVeggieByPriceDesc()
    {
        return veggieRepo.sortByPriceDesc();
    }

    public List<FruitDetails> SortFruiteByPriceDesc()
    {
        return fruiteRepo.sortByPriceDesc();
    }

    public List<DairyDetails> SortDairyByPriceDesc()
    {
        return dairyRepo.sortByPriceDesc();
    }

    public List<VegetableDetails> SortVeggieByNameAsc()
    {
        return veggieRepo.sortByNameAsc();
    }

    public List<FruitDetails> SortFruiteByNameAsc()
    {
        return fruiteRepo.sortByNameAsc();
    }

    public List<DairyDetails> SortDairyByNameAsc()
    {
        return dairyRepo.sortByNameAsc();
    }

    public List<VegetableDetails> SortVeggieByNameDesc()
    {
        return veggieRepo.sortByNameDesc();
    }

    public List<FruitDetails> SortFruiteByNameDesc()
    {
        return fruiteRepo.sortByNameDesc();
    }

    public List<DairyDetails> SortDairyByNameDesc()
    {
        return dairyRepo.sortByNameDesc();
    } 
    public AddtoCarts get(AddtoCarts add)
    {
        return addtion.save(add);
    }
    public productDetilas get(productDetilas product)
    {
        return prorepo.save(product);
    }


    public List<VegetableDetails> getSortedPages(int pageNo, int pageSize, String sortBy)
    {
        return veggieRepo.findAll(PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, sortBy))).getContent();
    }
    
    public List<VegetableDetails> getPages(int pageNo,int pageSize)
    {
        return veggieRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }
}
