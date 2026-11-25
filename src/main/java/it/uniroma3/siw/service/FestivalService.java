package it.uniroma3.siw.service;

//import

import it.uniroma3.siw.model.Festival;
import it.uniroma3.siw.repository.FestivalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {

    private final FestivalRepository festivalRepository;
    public FestivalService(FestivalRepository festivalRepository){this.festivalRepository = festivalRepository;}
    public List<Festival> findAll(){return festivalRepository.findAll();}
    public Optional<Festival> findById(long id){return festivalRepository.findById(id);}

    //Il cuoco chiede al magazziniere di mettere a scaffale il festival. save() è uno dei metodi regalati da JpaRepository, come findAll(). Restituisce il festival salvato, che ora ha un id: glielo dà il database.
    public Festival save(Festival festival){
        return festivalRepository.save(festival);
    }

    public List<Festival> findByCity(String city){
        return festivalRepository.findByCityContainingIgnoreCase(city);
    }
}
