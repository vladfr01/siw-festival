package it.uniroma3.siw.controller;

//import

import it.uniroma3.siw.model.Director;
import it.uniroma3.siw.service.DirectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

//classe
@Controller
public class DirectorController{

    private final DirectorService directorService;
    public DirectorController(DirectorService directorService){
        this.directorService = directorService;
    }

    //il cameriere mostra tuttu il menu dei registi
    @GetMapping("/directors")
    public String list(Model model){
        model.addAttribute("directors", directorService.findAll());
        return "directors/list";
    }

    //GET E POST MAPPING PER INSERIRE E VISUALIZZARE IL NUOVO REGISTA INSERITO DAL CLIENTE
    @GetMapping("/directors/new") //la voce del menu "voglio aggiungere un festival"
    public String newForm(Model model) {
        model.addAttribute("director", new Director());
        return "directors/form";
    }

    @PostMapping("/directors")
    public String save(@ModelAttribute("director") Director director) {
        Director saved = directorService.save(director); // il salvataggio del cuoco (che poi farebbe il magazzino)
        return "redirect:/directors/" + saved.getId();
    }

    //il cameriere mostra al cliente il direttore con quel specifico id (quindi il cliente ha scelto un direttore specifico)
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


