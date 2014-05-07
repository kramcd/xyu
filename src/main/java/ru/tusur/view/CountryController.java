package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Country;
import ru.tusur.service.CountryService;
import java.util.Collection;

@Controller
@RequestMapping(value = "country")
public class CountryController {


    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/")
    public ModelAndView countryList(){
        Collection<Country> countries = countryService.getAll();
        return new ModelAndView("listCountry", "countries", countries);
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView countryEdit(@RequestParam(value = "code", required = false) String code,
                                    @ModelAttribute("countryview") CountryPresenter presenter){
        if (!(code == null) && !(code.isEmpty())){
            presenter.setCountry(countryService.findByCode(code));
        }
        return new ModelAndView("editCountry", "countryview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView countryPost(@ModelAttribute CountryPresenter presenter){
        //Country country = presenter.getCountry();
        countryService.save(presenter.getCountry());
        return new ModelAndView("redirect:/country/");
    }
}
