package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Director;
import it.uniroma3.siw.repository.DirectorRepository;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    public DirectorService(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    public List<Director> findAll(){
        return directorRepository.findAll();
    }

    public Optional<Director> findById(long id){
        return directorRepository.findById(id);
    }

}