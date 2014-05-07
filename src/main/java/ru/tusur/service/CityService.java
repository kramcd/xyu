package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tusur.data.DAO;
import ru.tusur.domain.City;

import java.util.Collection;

/**
 * xyu
 * ru.tusur.service
 * by Oleg Alekseev
 * 15.04.14.
 */
@Service
public class CityService {

    @Autowired
    @Qualifier("CityDAO")
    private DAO<City> cityDAO;

    public Collection<City> getAllCities(){
        return cityDAO.getAll();
    }

    public City getByCode(String code) {
        int id;
        try {
            id = Integer.parseInt(code);
        } catch (Exception ex) {
            id = 0;
        }
        return cityDAO.getById(id);
    }

    public void insert(City city){
        cityDAO.insert(city);
    }

    public void update(City city) {
        cityDAO.save(city);
    }

    public void remove(City city){
        cityDAO.remove(city);
    }

}
