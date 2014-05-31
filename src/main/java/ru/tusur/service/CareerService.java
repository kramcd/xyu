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

    @Autowired
    private EmployeesService employees_service;

    public Career Save(Career career){
        career.getEmployees().setPost(career.getPost());
        employees_service.Save(career.getEmployees());
        return repository.save(career);
    }

    public List<Career> GetAll(){
        return repository.findAll();
    }

    public void Delete(Career career){
        repository.delete(career);
    }

    public Career FindById(Integer code){
        return repository.findById(code);
    }

    public List<Career> FindByEmployees_id(Integer code){
        return repository.findByEmployees_Id(code);
    }

   /* public Career FindByPost(Post post){
        return repository.findByPost(post);
    }*/

}
