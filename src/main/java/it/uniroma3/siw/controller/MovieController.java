package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.MovieService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String list(Model model){
        model.addAttribute("movies", movieService.findAll());
        return "movies/list";
    }
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