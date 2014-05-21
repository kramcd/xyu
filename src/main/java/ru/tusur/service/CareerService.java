package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tusur.data.CareerRepository;
import ru.tusur.domain.Career;

import java.util.List;

@Service("CareerService")
public class CareerService {

    @Autowired
    private CareerRepository repository;

    public Career Save(Career career){
        return repository.save(career);
    }

    public List<Career> GetAll(){
        return repository.findAll();
    }

    public Career FindById(Integer code){
        return repository.findById(code);
    }

   /* public Career FindByPost(Post post){
        return repository.findByPost(post);
    }*/

}