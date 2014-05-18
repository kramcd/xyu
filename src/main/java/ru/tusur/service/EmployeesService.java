package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tusur.data.EmployeesRepository;
import ru.tusur.domain.Employees;

import java.util.List;

@Service("EmployeesService")

public class EmployeesService {

    @Autowired
    private EmployeesRepository repository;

    public Employees Save(Employees employees){
        return repository.save(employees);
    }

    public List<Employees> GetAll(){
        return repository.findAll();
    }

    public Employees FindtByCode(String code){
        return repository.findByCode(code);
    }


}
