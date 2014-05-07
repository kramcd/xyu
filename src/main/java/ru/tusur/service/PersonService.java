package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tusur.data.DAO;
//import ru.tusur.domain.City;
import ru.tusur.domain.Person;

import java.security.PublicKey;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class PersonService {
    @Autowired
    @Qualifier("PersonDAO")
    private DAO<Person> personDAO;

    public Collection<Person> getAllPersons(){
        return personDAO.getAll();
    }

    public Person getByCode(String code){
        int id;
        try {
           id = Integer.parseInt(code);
        }
        catch (Exception ex){
            id = 0;
        }
        return personDAO.getById(id);
    }

    public Collection<Person> getPersonFromCity(String city){
        return  getAllPersons().stream().filter
                (Persons -> Persons.getCity().getName().equals(city)).collect(Collectors.toList());

    }
    
    public Person getByName(String name){
        return (Person) getAllPersons().stream().filter
               (Person -> Person.getName().equals(name));
    }

    public Collection<Person> getAdultPerson(){
        return getAllPersons().stream().filter
        (Person -> Person.getAge() > 17).collect(Collectors.toList());
    }

    public void insert(Person person){
        personDAO.insert(person);
    }

    public void update(Person person){
        personDAO.save(person);
    }

    public void remove(Person person){
        personDAO.remove(person);
    }

}
