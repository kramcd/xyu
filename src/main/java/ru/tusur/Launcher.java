package ru.tusur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.tusur.domain.City;
import ru.tusur.domain.Country;
import ru.tusur.service.CityService;
import ru.tusur.service.CountryService;

import java.util.Collection;
import java.util.List;


@Component
public class Launcher {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Launcher launcher = context.getBean(Launcher.class);

        Country russia = new Country("RU", "Russia");
        Country usa = new Country("US", "United State of America");
        Country ua = new Country("UA", "Ukraine");

        russia = launcher.countryService.save(russia);
        usa = launcher.countryService.save(usa);
        ua = launcher.countryService.save(ua);

        List<Country> countries = launcher.countryService.getAll();
        countries.forEach( (c) -> System.out.printf
                ("%d:%s\t%s\n", c.getId(),c.getCode(), c.getName()));
        System.out.println();

        Country country = launcher.countryService.findByCode("UA");
        System.out.println(country.getId()+" "+country.getName());
/*
        Collection<City> cities = launcher.service.getAllCities();

        cities.forEach(System.out::println);
*/
    }

}
