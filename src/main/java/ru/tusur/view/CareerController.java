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
import ru.tusur.domain.Career;
import ru.tusur.domain.Employees;
import ru.tusur.service.CareerService;
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
@RequestMapping(value = "career")
public class CareerController {

    @Autowired
    private CareerService service;

    @Autowired
    EmployeesService employees_service;

    @Autowired
    ReportService report_service;

    @RequestMapping(value = "/")
    public ModelAndView careerList(@RequestParam(value = "employees_code", required = true) Integer employees_code,
                                   @ModelAttribute("careerview") CareerPresenter presenter){
        Collection<Career> careers = service.FindByEmployees_id(employees_code);
        ModelAndView result = new ModelAndView("listCareer");
        result.addObject("careers", careers);
        result.addObject("careerview", employees_service.FindById(employees_code));
        return result;
    }

    @RequestMapping(value = "/{employeeId}/delete/")
    public ModelAndView careerDelete(@RequestParam(value = "code", required = false) String code,
                                        @ModelAttribute("careerview") CareerPresenter presenter,
                                        @PathVariable int employeeId){
        if(code == null || code.length()  <= 0){}
        else{
            service.Delete(service.FindById(Integer.parseInt(code)));
        }
        return new ModelAndView("redirect:/career/?employees_code=" + employeeId);
    }

    @RequestMapping(value = "/{employeeId}/edit/")
    public ModelAndView careerEdit(@RequestParam(value = "code", required = false) String code,
                                   @ModelAttribute("careerview") CareerPresenter presenter,
                                   @PathVariable int employeeId){
        Career career;
        career = new Career();
        if(code == null || code.length() <= 0){
            presenter.setCareer(career);
            }
        else {
            career = service.FindById(Integer.parseInt(code));
            career.setEmployees(employees_service.FindById(employeeId));
            presenter.setCareer(career);
            presenter.setdDate(DateUtils.stringFromLocalDate(DateUtils.localFromSqlDate(presenter.getCareer().getdDate())));
        }

        return new ModelAndView("editCareer", "careerview", presenter);
    }



    @RequestMapping(value = "/{employeeId}/edit/save/", method = RequestMethod.POST)
    public ResponseEntity careerPost(@ModelAttribute CareerPresenter presenter,
                                   @PathVariable int employeeId,
                                   HttpServletRequest request) throws IOException, DocumentException {

        LocalDate dDate = LocalDate.parse(request.getParameter("dDate"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Instant instant = dDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getCareer().setdDate(new java.sql.Date(Date.from(instant).getTime()));
        presenter.getCareer().setEmployees(employees_service.FindById(employeeId));
        //service.Save(presenter.getCareer());
        presenter.setCareer(service.Save(presenter.getCareer()));
        byte[] pdfContents = report_service.prikazEditPostEmployees(employees_service.FindById(employeeId).getFamaly(), employees_service.FindById(employeeId).getName(),
                employees_service.FindById(employeeId).getMiddleName(), request.getParameter("career.Post"));

    HttpHeaders headers = new HttpHeaders();
    String fileName = "report";
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.setContentDispositionFormData(fileName, fileName);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    return new ResponseEntity(pdfContents, headers, HttpStatus.OK);
    }


}
