//CAMERIERE
package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Movie;
import java.util.Optional;

import org.springframework.stereotype.Controller; //cartellino che dice che qeusta classe e' il cameriere
import org.springframework.ui.Model; //il vassoio del cameriere, serve a metterci i dati sfornati dal cuoco in modo da poterli dare alla pagina HTML
import org.springframework.web.bind.annotation.GetMapping; //serve al cameriere per capire cosa vuole il cliente

import it.uniroma3.siw.service.MovieService; //serve a collegare il cameriere al cuoco
import org.springframework.web.bind.annotation.PathVariable; //serve a leggere le informazioni variabili dentro al sito internet


@Controller
public class MovieController {

    //creiamo la variabile cameriere e poi assegnamo questa variabile al cuoco tramite costrutture
    private final MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies") //se l'utente digita sul browser www.sit.it/movies, sio attiva qeusto metodo
    public String list(Model model){
        model.addAttribute("movies", movieService.findAll()); //il cameriere prende la lista di film ricevutra dal cuoco e la appoggia sul suo vassoio | cuoco mi dai tutti i film??
        return "movies/list";
    }

    //stessa roba ma voglio vedere i dettagli sul film SPECIFICO
    @GetMapping("/movies/{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isEmpty()) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie.get());
        return "movies/show";
    }
}