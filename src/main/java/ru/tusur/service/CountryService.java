package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tusur.data.CountryRepository;
import ru.tusur.domain.Country;

import java.util.List;

@Service("countryService")
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Country save(Country country){
        return repository.save(country);
    }

    public List<Country> getAll(){
        return repository.findAll();
    }

    public Country findByCode(String code){
        return repository.findByCode(code);
    }

}

