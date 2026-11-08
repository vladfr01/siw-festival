//CUOCO / PADRE DIO
package it.uniroma3.siw.service;

import java.util.List; //import che serve a creare una lista di tanti film
import java.util.Optional; // import necessario ad evitare che il programma vadi in crash nel caso in cui si cerchi un film che non esiste

import org.springframework.stereotype.Service; //import del framework di spring che ci servira' a dire che MovieServie e' il Cuoco

import it.uniroma3.siw.model.Movie; //import che serve a dire al cuoco qual e' l'ogeto su cui dovra lavorare
import it.uniroma3.siw.repository.MovieRepository; //import che serve a dire al cuoco il nome del suo aiuto-cuoco

//andiamo qua a creare il cuoco e a collegarlo al suo ambiente di lavoro
@Service
public class MovieService {

    //creiamo la variabile aiuto-cuoco e poi assegnamo questa variabile al cuoco tramite costrutture
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    //il controller(cameriere) chiede al service(cuoco) "dammi tutti i film" e il cuoco delega il lavoro al repository(aiuto-cuoco) il quale restituira tutti i film
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    //metodo per cercare un film specifico
    public Optional<Movie> findById(long id){
        return movieRepository.findById(id);
    }

}