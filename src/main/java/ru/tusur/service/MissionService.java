package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tusur.data.MissionRepository;
import ru.tusur.domain.Mission;

import java.util.List;

@Service("MissionService")
public class MissionService {

    @Autowired
    private MissionRepository repository;

    public Mission Save(Mission mission){
        return repository.save(mission);
    }

    public List<Mission> GetAll(){
        return repository.findAll();
    }

    public List<Mission> FindByEmployees_id(Integer code){
        return repository.findByEmployees_Id(code);
    }

    public void Delete(Mission mission){
        repository.delete(mission);
    }

    public Mission FindById(Integer code){
        return repository.findOne(code);
    }

}
