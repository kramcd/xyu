package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.City;
import ru.tusur.service.CityService;

import java.util.Collection;

@Controller
@RequestMapping(value = "city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/")
    public ModelAndView citiesList() {
        Collection<City> cities = cityService.getAllCities();
        return new ModelAndView("listCity", "cities", cities);
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView cityEdit( @RequestParam(value = "code", required = false) String code,
                                  @ModelAttribute("cityview") CityPresenter presenter) {
        if (code == null || code.length()  <= 0) {
            presenter.setPersisted(false);
        } else {
            presenter.setCity(cityService.getByCode(code));
            presenter.setPersisted(true);
        }
        return new ModelAndView("editCity", "cityview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView cityPost(@ModelAttribute CityPresenter presenter) {
        City city = presenter.getCity();
        if (presenter.isPersisted()) {
            cityService.update(city);
        } else {
            cityService.insert(city);
        }
        return new ModelAndView("redirect:/city/");
    }

}
