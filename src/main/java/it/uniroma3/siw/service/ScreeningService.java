package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Screening;
import it.uniroma3.siw.repository.ScreeningRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public List<Screening> findByFestival(Long festivalId) {
        return screeningRepository.findByFestivalOrdered(festivalId);
    }
}