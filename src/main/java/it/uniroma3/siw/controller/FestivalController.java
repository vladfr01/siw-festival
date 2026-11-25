//CAMERIERE
package it.uniroma3.siw.controller;

//tutti i diversi import

import it.uniroma3.siw.model.Festival;
import it.uniroma3.siw.service.FestivalService;
import it.uniroma3.siw.service.ScreeningService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class FestivalController {

    //creo variabile cuoco dentro questa classe
    private final FestivalService festivalService;
    private final ScreeningService screeningService;

    public FestivalController(FestivalService festivalService, ScreeningService screeningService) {
        this.festivalService = festivalService;
        this.screeningService = screeningService;
    }

    //il cameriere porta al cliente il modulo vuoto per inserire il nuovo piatto dentro al menu
    @GetMapping("/festivals/new") //la voce del menu "voglio aggiungere un festival"
    public String newForm(Model model) {
        model.addAttribute("festival", new Festival());
        return "festivals/form";
    }

    //il cameriere riceve il modulo compilato
    @PostMapping("/festivals")
    public String save(@ModelAttribute("festival") Festival festival){
        Festival saved = festivalService.save(festival); // il salvataggio del cuoco (che poi farebbe il magazzino)
        return "redirect:/festivals/" + saved.getId();
    }

    @GetMapping("/festivals/{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Festival> festival = festivalService.findById(id);
        if (festival.isEmpty()) {
            return "redirect:/festivals";
        }
        model.addAttribute("festival", festival.get());
        model.addAttribute("screenings", screeningService.findByFestival(id));
        return "festivals/show";
    }

    @GetMapping("/festivals")
    public String list(@RequestParam(required = false) String city, Model model){
        if (city == null || city.isBlank()) {
            model.addAttribute("festivals", festivalService.findAll());
        } else {
            model.addAttribute("festivals", festivalService.findByCity(city));
        }
        model.addAttribute("city", city);
        return "festivals/list";
    }
}
