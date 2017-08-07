package me.jerilynmensah.demo.controllers;

import me.jerilynmensah.demo.models.Name;
import me.jerilynmensah.demo.repositories.NameRepository;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.All;

@Controller
public class MainController


{
	Date date = new Date();
	dateFormat df = new simpleDateFormat("mm/dd/yyyy");
	
	@Auotwired
	NameRepository nameRespository;
	
    @GetMapping("/")
    public String showIndex (Model model){
        String myMessage = "Welcome to Robo Resume!";
        model.addAttribute("message", myMessage);
        return "index";
    }

    @GetMapping("/addname")
    public String showName (Model model)
    {
        model.addAttribute("newName",  showName());
        return "addname";
    }

    @GetMapping("/addemail")
    public String showEmail (Model model)
    {
        model.addAttribute("newEmail", showEmail());
        return "addemail";
    }

    @GetMapping("/addorganization")
    public String showOrganization (Model model)
    {
        model.addAttribute("newOrganization", showOrganization());
        return "addorganization";

    }

    @GetMapping("/startdate")
    public String showStartDate (Model model)
    {
        model.addAttribute("newStartDate", showStartDate());
        return "startdate";
    }

    @GetMapping("/enddate")
    public String showEndDate (Model model)
    {
        model.addAttribute("newenddate", showEndDate());
        return "enddate";
    }

    @PostMapping("/showAllData")
    public String showAllData (@Valid @ModelAttribute ("allData") data Data, BindingResult bindingResult )
    {
        if(bindingResult.hasErrors());
        return "showalldata;"
    }
        

    @GetMapping("/showalldata")
    public @ResponseBody String showAllData()
    {
        Iterable<Name> nameList = NameRepository.findAll();
        return nameList.toString();
    }

}
