package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Person;
import ru.tusur.service.PersonService;

import java.util.Collection;

/**
 * Created by kramc_000 on 18.04.14.
 */

@Controller
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/")
    public ModelAndView personsList(@RequestParam(value = "adult", required = false) boolean adult,
                                    @RequestParam(value = "city", required = false) String city){
        Collection<Person> persons;
        if ((city == null || city.length() <= 0) & (!adult)){
        persons = personService.getAllPersons();
        }
        else {
            if (!adult){
                persons = (Collection<Person>)personService.getPersonFromCity(city);
            }
            else {
                persons = personService.getAdultPerson();
            }
        }
        return new ModelAndView("listPerson", "persons", persons);
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView personEdit(@RequestParam(value = "code", required = false) String code,
                                   @ModelAttribute("personview") PersonPresenter presenter){
        if (code == null || code.length()  <= 0) {
            presenter.setPersisted(false);
        } else {
            presenter.setPerson(personService.getByCode(code));
            presenter.setPersisted(true);
        }
        return new ModelAndView("editPerson", "personview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView personPost(@ModelAttribute PersonPresenter presenter){
        Person person = presenter.getPerson();
        if (presenter.isPersisted())
            personService.update(person);
        else {
            personService.insert(person);
        }
        return new ModelAndView("redirect:/person/");
    }



}
