package it.uniroma3.siw.service;

//import
import java.util.List;
import java.util.Optional;

import it.uniroma3.siw.model.Festival;
import it.uniroma3.siw.repository.FestivalRepository;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.model.Director;
import it.uniroma3.siw.repository.DirectorRepository;

@Service
public class FestivalService {

    private final FestivalRepository festivalRepository;
    public FestivalService(FestivalRepository festivalRepository){this.festivalRepository = festivalRepository;}
    public List<Festival> findAll(){return festivalRepository.findAll();}
    public Optional<Festival> findById(long id){return festivalRepository.findById(id);}
}
