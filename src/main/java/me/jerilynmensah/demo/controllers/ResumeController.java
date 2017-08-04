package me.jerilynmensah.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.transform.Result;

@Controller
public class ResumeController {

    @GetMapping("/result")
    public String resultForm(Model model){
        model.addAttribute("result", new Result());
        return "result";
    }


}
