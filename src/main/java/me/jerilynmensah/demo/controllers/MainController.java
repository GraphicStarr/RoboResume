package me.jerilynmensah.demo.controllers;

import me.jerilynmensah.demo.models.Job;
import me.jerilynmensah.demo.repositories.NameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.LocalDate;

import static java.util.concurrent.TimeUnit.DAYS;

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
        model.addAttribute("newName",  showName());
        return "addname";
    }

    @GetMapping("/addemail")
    public String showEmail (Model model){
        model.addAttribute("newEmail", showEmail());
        return "addemail";
    }

    @GetMapping("/addorganization")
    public String showOrganization (Model model){
        model.addAttribute("newOrganization", showOrganization());
        return "addorganization";

    }

    @GetMapping("/startdate")
    public String showStartDate (Model model){
        model.addAttribute("newStartDate", showStartDate());
        return "startdate";
    }

    @GetMapping("/enddate")
    public String showEndDate (Model model){
        model.addAttribute("newenddate", showEndDate());
        return "enddate";
    }

    @PostMapping("/addjob")
    public String showAddJob (@Valid @ModelAttribute ("addJob") new Job, BindingResult bindingResult )
    {
        Model model;
        model.addAttribute("addjob", new Job());

        if(bindingResult.hasErrors();
        {
            return "addjob";
        }

        // Prompt user to enter employment information
        if (job.getName().isEmpty())
        {
            job.setName = ("");
        }
        if (job.getEmail().isEmpty()) {

            job.setEmail = ("");
        }
        if (job.getOrganization().isEmpty())
        {
            job.setOrganization() = ("");
        }
        if (job.getStartDate().isEmpty()) {

            job.setStartDate = ("");

        if(job.getEndDate()== null)

        {
            System.out.println("end null!");
            job.setEndDate(LocalDate.now());
        }

        }

        // Calculate the number of days in job
        job.setDaysEmployed(DAYS.between(job.getStartDate(), job.getEndDate()));
        //save the job to the database
        jobs.save(job);
        return "jobadded";


    @GetMapping("/viewresume")
    public @ResponseBody String viewresume(Model model)
    {
        Iterable<Resume> jobList = NameRepository.findAll();
        model.addAttribute("job", Job);
        return "viewresume";
    }

}
}
