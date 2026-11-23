
//CAMERIERE
package it.uniroma3.siw.controller;

//tutti i diversi import

import it.uniroma3.siw.model.Festival;
import it.uniroma3.siw.service.FestivalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class FestivalController {

        //creo variabile cuoco dentro questa classe
        private final FestivalService festivalService;
        public FestivalController(FestivalService festivalService){
            this.festivalService = festivalService;
        }

        @GetMapping("/festivals")
        public String list(Model model){
            model.addAttribute("festivals", festivalService.findAll());
            return "festivals/list";
        }

    @GetMapping("/festivals/{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Festival> festival = festivalService.findById(id);
        if (festival.isEmpty()) {
            return "redirect:/festivals";
        }
        model.addAttribute("festival", festival.get());
        return "festivals/show";
    }
}
