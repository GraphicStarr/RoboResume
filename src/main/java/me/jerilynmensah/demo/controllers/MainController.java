package me.jerilynmensah.demo.controllers;

import me.jerilynmensah.demo.models.Name;
import me.jerilynmensah.demo.repositories.NameRepository;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController


{
    @GetMapping("/")
    public String showIndex (Model model){
        String myMessage = "Welcome to Robo Resume!";
        model.addAttribute("message", myMessage);
        return "index";
    }

    @GetMapping("/addname")
    public String showName (Model model){
        model.addAttribute("newName", new Name());
        return "addname";
    }

    @GetMapping("/addemail")
    public String showEmail (Model model){
        model.addAttribute("newEmail", new Email());
        return "addemail";
    }

    @GetMapping("/addorganization")
    public String showOrganization (Model model){
        model.addAttribute("newOrganization", new Organization());
        return "addorganization";

    }

    @GetMapping("/startdate")
    public String showStartDate (Model model){
        model.addAttribute("newStartDate", new StartDate());
        return "startdate";
    }

    @GetMapping("/enddate")
    public String showEndDate (Model model){
        model.addAttribute("newenddate", new EndDate());
        return "enddate";
    }

    @PostMapping("/showAllData")
    public String showAllData (@Valid @ModelAttribute){
        model.addAttribute("newAllData")
    }


}
