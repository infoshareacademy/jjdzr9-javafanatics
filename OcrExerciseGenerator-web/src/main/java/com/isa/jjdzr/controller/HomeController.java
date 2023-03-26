package com.isa.jjdzr.controller;

import com.isa.jjdzr.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class HomeController {

    private final ExerciseService exerciseService;


    // http://localhost:8080
    @GetMapping
    public String getHome(){
        return "home";
    }
    @GetMapping(path = "/generate-pdf")
    public String generatePdf(){
        try {
            exerciseService.generatePdf();
        }catch (Exception e){
            System.out.println("Could not generate pdf ! :(\n" + e.getMessage());
        }
        return "home";
    }

}
