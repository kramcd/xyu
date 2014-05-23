package ru.tusur.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.tusur.service.MissionService;

@Controller
@RequestMapping(value = "mission")
public class MissionController {

    @Autowired
    private MissionService service;

    @RequestMapping(value = "/")
    public ModelAndView missionList(){
        return null;
    }

}
