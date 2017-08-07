package me.jerilynmensah.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.transform.NewEmployee;

@Controller
public class ResumeController {

    @GetMapping("/newemployee")
    public String resultForm(Model model){
        model.addAttribute("newemployee", new NewEmployee());
        return "newemployee";
    }


}
