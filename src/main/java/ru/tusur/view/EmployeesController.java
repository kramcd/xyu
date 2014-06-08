package ru.tusur.view;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Employees;
import ru.tusur.service.EmployeesService;
import ru.tusur.service.ReportService;
import ru.tusur.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @Autowired
    private ReportService report_service;

    @RequestMapping(value = "/")
    public ModelAndView employeesList() {
        Collection<Employees> employeeses = service.GetAll();
        return new ModelAndView("listEmployees", "employeeses", employeeses);
    }

    @RequestMapping(value = "/delete/")
    public ModelAndView employeesDelete(@RequestParam(value = "code", required = false) String code,
                                        @ModelAttribute("employeesview") EmployeesPresenter presenter) {
        if (code == null || code.length() <= 0) {
        } else {
            service.Delete(service.FindById(Integer.parseInt(code)));
        }
        return new ModelAndView("redirect:/employees/");
    }

    @RequestMapping(value = "/edit/")
    public ModelAndView employeesEdit(@RequestParam(value = "code", required = false) String code,
                                      @ModelAttribute("employeesview") EmployeesPresenter presenter) {
        if (code == null || code.length() <= 0) {
        } else {
            presenter.setEmployees(service.FindById(Integer.parseInt(code)));
            presenter.setBithDay(DateUtils.stringFromLocalDate(DateUtils.localFromSqlDate(presenter.getEmployees().getBithDay())));
            presenter.setEmployeementDate(DateUtils.stringFromLocalDate(DateUtils.localFromSqlDate(presenter.getEmployees().getEmployeementDate())));
        }
        return new ModelAndView("editEmployees", "employeesview", presenter);
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ResponseEntity employeesPost(@ModelAttribute EmployeesPresenter presenter,
                                        HttpServletRequest request,
                                        BindingResult errors
    ) throws IOException, DocumentException {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        LocalDate date = LocalDate.parse(request.getParameter("bithDay"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getEmployees().setBithDay(new java.sql.Date(Date.from(instant).getTime()));

        LocalDate edate = LocalDate.parse(request.getParameter("employeementDate"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        instant = edate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getEmployees().setEmployeementDate(new java.sql.Date(Date.from(instant).getTime()));

        presenter.setEmployees(service.Save(presenter.getEmployees()));

        byte[] pdfContents = null;

        if (request.getParameter("employees.id") == "0") {
             pdfContents = report_service.prikazAddPostEmployees(request.getParameter("employees.famaly"), request.getParameter("employees.name"),
                    request.getParameter("employees.middleName"), request.getParameter("employees.post"));
        }
        else {
            pdfContents = report_service.prikazEditPostEmployees(request.getParameter("employees.famaly"), request.getParameter("employees.name"),
                    request.getParameter("employees.middleName"), request.getParameter("employees.post"));
        }
        HttpHeaders headers = new HttpHeaders();
        String fileName = "report";
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity(pdfContents, headers, HttpStatus.OK);

    }
}
