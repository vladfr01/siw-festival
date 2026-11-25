//CUOCO / PADRE DIO
package it.uniroma3.siw.service;

import java.util.List; //import che serve a creare una lista di tante room
import java.util.Optional; // import necessario ad evitare che il programma vadi in crash nel caso in cui si cerchi una room che non esiste

import org.springframework.stereotype.Service; //import del framework di spring che ci servira' a dire che RoomServie e' il Cuoco

import it.uniroma3.siw.model.Room; //import che serve a dire al cuoco qual e' l'oggeto su cui dovra lavorare
import it.uniroma3.siw.repository.RoomRepository; //import che serve a dire al cuoco il nome del suo aiuto-cuoco

//andiamo qua a creare il cuoco e a collegarlo al suo ambiente di lavoro
@Service
public class RoomService {

    //creiamo la variabile aiuto-cuoco e poi assegnamo questa variabile al cuoco tramite costrutture
    private final RoomRepository roomRepository;
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    //il controller(cameriere) chiede al service(cuoco) "dammi tutte le room" e il cuoco delega il lavoro al repository(aiuto-cuoco) il quale restituira tutte le room
    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    //metodo per cercare un film specifico
    public Optional<Room> findById(long id){
        return roomRepository.findById(id);
    }

}