package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Screening;
import it.uniroma3.siw.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// CUOCO delle proiezioni
@Service
public class ScreeningService {

    // il suo magazziniere, ricevuto tramite costruttore
    private final ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    // il programma di un festival: le sue proiezioni ordinate per orario
    public List<Screening> findByFestival(Long festivalId) {
        return screeningRepository.findByFestivalOrdered(festivalId);
    }
}