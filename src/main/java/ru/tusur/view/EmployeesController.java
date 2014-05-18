package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Employees;
import ru.tusur.service.EmployeesService;

import java.util.Collection;

@Controller
@RequestMapping(value = "employees")
public class EmployeesController {

    @Autowired
    private EmployeesService service;

    @RequestMapping(value = "/")
    public ModelAndView employeesList(){
        Collection<Employees> employeeses = service.GetAll();
        return new ModelAndView("listEmployees", "employeeses", employeeses);
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView employeesEdit(@RequestParam(value = "code", required = false) String code,
                                      @ModelAttribute("employeesview") EmployeesPresenter presenter){
        if(!(code == null) && !(code.isEmpty())){
            presenter.setEmployees(service.FindtByCode(code));
        }
        return new ModelAndView("editEmployees", "employeesview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView employeesPost(@ModelAttribute EmployeesPresenter presenter){
        service.Save(presenter.getEmployees());
        return new ModelAndView("redirect:/employees/");
    }
}
