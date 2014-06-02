package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.domain.Mission;
import ru.tusur.service.EmployeesService;
import ru.tusur.service.MissionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Controller
@RequestMapping(value = "mission")
public class MissionController {

    @Autowired
    private MissionService service;

    @Autowired
    EmployeesService employees_service;

    @RequestMapping(value = "/")
    public ModelAndView missionList(@RequestParam(value = "employees_code",
            required = true) Integer employees_code){
        Collection<Mission> missions = service.FindByEmployees_id(employees_code);
        ModelAndView result = new ModelAndView("listMission");
        result.addObject("missions", missions);
        result.addObject("missionview", employees_service.FindById(employees_code));
        return result;
    }

    @RequestMapping(value = "/{employeeId}/delete/")
    public ModelAndView missionDelete(@RequestParam(value = "code", required = false) String code,
                                     @ModelAttribute("missionview") MissionPresenter presenter,
                                     @PathVariable int employeeId){
        if(code == null || code.length()  <= 0){}
        else{
            service.Delete(service.FindById(Integer.parseInt(code)));
        }
        return new ModelAndView("redirect:/mission/?employees_code=" + employeeId);
    }

    @RequestMapping(value = "/{employeesId}/edit/")
    public ModelAndView missionEdit (@RequestParam(value = "code",required = false)
                                     String code, @PathVariable int employeesId,
                                     @ModelAttribute("missionview") MissionPresenter presenter){
        Mission mission;
        if(code == null || code.length() <= 0){
            mission = new Mission();
        }
        else {
            mission = service.FindById(Integer.parseInt(code));
        }
        mission.setEmployees(employees_service.FindById(employeesId));
        presenter.setMission(mission);
        return new ModelAndView("editMission", "missionview", presenter);
    }

    @RequestMapping(value = "/{employeesId}/edit/save/", method = RequestMethod.POST)
    public ModelAndView missionPost(@ModelAttribute MissionPresenter presenter, BindingResult result,
                                    @PathVariable int employeesId, HttpServletRequest request){
       /* if (result.hasErrors()){
            for(ObjectError error : return result.getAllErrors()){
                System.out.println(error.getDefault);
            }
        }*/
        LocalDate dDate = LocalDate.parse(request.getParameter("dispatchDate"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Instant instant  = dDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getMission().setDispatchDate(new java.sql.Date(Date.from(instant).getTime()));

        LocalDate rDate = LocalDate.parse(request.getParameter("dispatchDate"),
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        instant  = rDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        presenter.getMission().setReturnDate(new java.sql.Date(Date.from(instant).getTime()));

        presenter.getMission().setEmployees(employees_service.FindById(employeesId));
        service.Save(presenter.getMission());

        return new ModelAndView("redirect:/mission/?employees_code=" + employeesId);
    }

}
