package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Statement;
import ru.tusur.service.EmployeesService;
import ru.tusur.service.StatementService;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping(value = "statement")
public class StatementController {

    @Autowired
    private StatementService service;

    @Autowired
    EmployeesService employees_service;

    @RequestMapping(value = "/")
    public ModelAndView statementList(@RequestParam(value = "employees_code",
            required = true) Integer employees_code){
        Collection<Statement> statements = service.FindByEmployees_id(employees_code);
        return new ModelAndView("listStatement", "statements", statements);
    }

    @RequestMapping(value = "/{employeesId}/edit/")
    public ModelAndView statementEdit (@RequestParam(value = "code",required = false)
                                     String code, @PathVariable int employeesId,
                                     @ModelAttribute("statementnview") StatementPresenter presenter){
        Statement statement;
        if(code == null || code.length() <= 0){
            statement = new Statement();
        }
        else {
            statement = service.FindById(Integer.parseInt(code));
        }
        statement.setEmployees(employees_service.FindById(employeesId));
        presenter.setStatement(statement);
        return new ModelAndView("editStatement", "statementview", presenter);
    }

    @RequestMapping(value = "/{employeesId}/edit/save/", method = RequestMethod.POST)
    public ModelAndView statementPost(@ModelAttribute StatementPresenter presenter, BindingResult result,
                                    @PathVariable int employeesId, HttpServletRequest request){
        if (result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        LocalDate sDate = LocalDate.parse(request.getParameter("startDate"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Instant instant  = sDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getStatement().setStartDate(new java.sql.Date(Date.from(instant).getTime()));

        LocalDate eDate = LocalDate.parse(request.getParameter("endDate"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        instant  = eDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getStatement().setEndDate(new java.sql.Date(Date.from(instant).getTime()));

        LocalDate dpDate = LocalDate.parse(request.getParameter("dpDate"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        instant  = dpDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getStatement().setDpDate(new java.sql.Date(Date.from(instant).getTime()));

        presenter.getStatement().setEmployees(employees_service.FindById(employeesId));
        service.Save(presenter.getStatement());

        return new ModelAndView("redirect:/statement/?employees_code=" + employeesId);
    }

}
