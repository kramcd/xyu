package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Employees;
import ru.tusur.service.EmployeesService;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

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

    @RequestMapping(value = "/delete/")
    public ModelAndView employeesDelete(@RequestParam(value = "code", required = false) String code,
                                      @ModelAttribute("employeesview") EmployeesPresenter presenter){
        if(code == null || code.length()  <= 0){}
        else{
           service.Delete(service.FindById(Integer.parseInt(code)));
            }
        return new ModelAndView("redirect:/employees/");
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView employeesEdit(@RequestParam(value = "code", required = false) String code,
                                      @ModelAttribute("employeesview") EmployeesPresenter presenter){
        if(code == null || code.length()  <= 0){}
        else{
            presenter.setEmployees(service.FindById(Integer.parseInt(code)));
        }
        return new ModelAndView("editEmployees", "employeesview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView employeesPost(@ModelAttribute EmployeesPresenter presenter,
                                      HttpServletRequest request,
                                      BindingResult errors
                                      ){
        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                System.out.println(error.getDefaultMessage());
            }
        }
        LocalDate date = LocalDate.parse(request.getParameter("bithDay"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getEmployees().setBithDay( new java.sql.Date(Date.from(instant).getTime()));
        service.Save(presenter.getEmployees());
        return new ModelAndView("redirect:/employees/");
    }
}
