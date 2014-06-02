package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Employees;
import ru.tusur.service.EmployeesService;
import ru.tusur.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping(value = "home")
public class MainController {

    @Autowired
    private EmployeesService service;

    @RequestMapping("/")
    public ModelAndView main(){
        ModelAndView result = new ModelAndView("view");
        //result.addObject("employeeslist",employeeslist );
        result.addObject("view",service.FindByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        return result;
    }


}
