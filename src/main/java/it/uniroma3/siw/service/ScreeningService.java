package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Screening;
import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.model.Room;
import it.uniroma3.siw.repository.MovieRepository;
import it.uniroma3.siw.repository.RoomRepository;
import it.uniroma3.siw.repository.ScreeningRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


// CUOCO delle proiezioni
@Service
public class ScreeningService {

    // il suo magazziniere, ricevuto tramite costruttore
    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;

    public ScreeningService(ScreeningRepository screeningRepository, MovieRepository movieRepository, RoomRepository roomRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
    }

    // il programma di un festival: le sue proiezioni ordinate per orario
    @Transactional(readOnly = true)
    public List<Screening> findByFestival(Long festivalId) {
        return screeningRepository.findByFestivalOrdered(festivalId);
    }

    @Transactional
    public Screening schedule(Long movieId, Long roomId, LocalDateTime startTime){
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();

        Screening screening = new Screening();
        screening.setMovie(movie);
        screening.setRoom(room);
        screening.setStartTime(startTime);

        return screeningRepository.save(screening);
    }

}