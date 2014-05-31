package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Career;
import ru.tusur.service.CareerService;
import ru.tusur.service.EmployeesService;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping(value = "career")
public class CareerController {

    @Autowired
    private CareerService service;

    @Autowired
    EmployeesService employees_service;

    @RequestMapping(value = "/")
    public ModelAndView careerList(@RequestParam(value = "employees_code", required = true) Integer employees_code){
        Collection<Career> careers = service.FindByEmployees_id(employees_code);
        return new ModelAndView("listCareer", "careers", careers);
    }

    @RequestMapping(value = "/{employeeId}/edit/")
    public ModelAndView careerEdit(@RequestParam(value = "code", required = false) String code,
                                   @PathVariable int employeeId,
                                   @ModelAttribute("careerview") CareerPresenter presenter){
        Career career;
        if(code == null || code.length() <= 0){
            career = new Career();
        }
        else {
            career = service.FindById(Integer.parseInt(code));
        }
        career.setEmployees(employees_service.FindById(employeeId));
        presenter.setCareer(career);
        return new ModelAndView("editCareer", "careerview", presenter);
    }

    @RequestMapping(value = "/{employeeId}/edit/save/", method = RequestMethod.POST)
    public ModelAndView careerPost(@ModelAttribute CareerPresenter presenter, BindingResult result,
                                   @PathVariable int employeeId,
                                   HttpServletRequest request){
        if (result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getCareer().setDate( new java.sql.Date(Date.from(instant).getTime()));
        presenter.getCareer().setEmployees(employees_service.FindById(employeeId));
        service.Save(presenter.getCareer());

        return new ModelAndView("redirect:/career/?employees_code=" + employeeId);
    }


}
