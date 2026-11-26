package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Director;
import it.uniroma3.siw.repository.DirectorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    public DirectorService(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    @Transactional(readOnly = true)
    public List<Director> findAll(){
        return directorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Director> findById(Long id){
        return directorRepository.findById(id);
    }

    //Il cuoco chiede al magazziniere di mettere a scaffale il festival. save() è uno dei metodi regalati da JpaRepository, come findAll(). Restituisce il festival salvato, che ora ha un id: glielo dà il database.
    @Transactional
    public Director save(Director director){
        return directorRepository.save(director);
    }

}