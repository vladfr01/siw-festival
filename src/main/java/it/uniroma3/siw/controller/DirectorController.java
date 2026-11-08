package it.uniroma3.siw.controller;

//import
import java.util.Optional;

import it.uniroma3.siw.model.Director;
import it.uniroma3.siw.service.DirectorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//classe
@Controller
public class DirectorController{

    private final DirectorService directorService;
    public DirectorController(DirectorService directorService){
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public String list(Model model){
        model.addAttribute("directors", directorService.findAll());
        return "directors/list";
    }

    @GetMapping("/directors/{id}")
    public String show(@PathVariable Long id, Model model){
        Optional<Director> director = directorService.findById(id);
        if (director.isEmpty()){
            return "redirect:/directors";
        }
        model.addAttribute("director", director.get());
        return "directors/show";
    }

}


