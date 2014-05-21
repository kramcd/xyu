package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Career;
import ru.tusur.service.CareerService;

import java.util.Collection;

@Controller
@RequestMapping(value = "career")
public class CareerController {

    @Autowired
    private CareerService service;

    @RequestMapping(value = "/")
    public ModelAndView careerList(){
        Collection<Career> careers = service.GetAll();
        return new ModelAndView("listCareer", "careers", careers);
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView careerEdit(@RequestParam(value = "code", required = false) String code,
                                   @ModelAttribute("careerview") CareerPresenter presenter){
        if(code == null || code.length() <= 0){}
        else {
            presenter.setCareer(service.FindById(Integer.parseInt(code)));
        }
        return new ModelAndView("editCareer", "careerview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView careerPost(@ModelAttribute CareerPresenter presenter){
        service.Save(presenter.getCareer());
        return new ModelAndView("reditrect:/carrer/");
    }


}
