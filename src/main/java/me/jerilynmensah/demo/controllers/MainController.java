package me.jerilynmensah.demo.controllers;

import me.jerilynmensah.demo.models.Job;
import me.jerilynmensah.demo.repositories.JobRespository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MainController{



    @Autowired
    JobRespository jobRepository;
    private String showResume;

    // This is the welcome page for Robo Resume
    @GetMapping("/")
    public String showIndex (Model model){
        String myMessage = "Welcome to Robo Resume!";
        model.addAttribute("message", myMessage);
        return "index";
    }

    // This will show the form of the resume

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

        // User will enter job into form
    @PostMapping("/addjob")
    public String showAddJob (@Valid @ModelAttribute ("addjob")Job job, BindingResult bindingResult)
    {
        Model model;
        model.addAttribute("addjob", new Job());

        if(bindingResult.hasErrors());
        {
            return "addjob";
        }

        // Prompt user to enter employment information

        Job job = new Job();

        if (!job.getName().isEmpty()) {
        } else {
            job.setName() = ("");
        }
        if (job.getEmail().isEmpty()) {

            job.setEmail() = ("");
        }
        if (job.getOrganization().isEmpty())
        {
            job.setOrganization() = ("");
        }
        if (!job.getStartDate().isEmpty()) {
        }
            else{

            job.setStartDate() = ("");

        if(job.getEndDate()== null)

        {
            System.out.println("end null!");
            job.setEndDate(LocalDate.now());
        }

        }

        /** Calculate the number of days in job
        * by converting the dates in mm/dd/yyyy
        * format to long number of days
         */

        job.setDaysEmployed(DAYS.toDays(LocalDate.parse(job.getStartDate()), LocalDate.parse(job.getEndDate())));

        // The job is stored into database
        jobRepository.save(job);
        return "jobadded";

    @GetMapping("/showjob")
    public String showJob(Model model)
    {
        Iterable<Job> jobList = jobRepository.findAll();

        // Show information of resume
        model.addAttribute("job", jobList);
        return "showjob";
    }

    }
}
