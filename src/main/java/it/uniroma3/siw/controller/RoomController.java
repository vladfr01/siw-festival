//CAMERIERE
package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Room;
import it.uniroma3.siw.service.RoomService;
import org.springframework.stereotype.Controller; //cartellino che dice che qeusta classe e' il cameriere
import org.springframework.ui.Model; //il vassoio del cameriere, serve a metterci i dati sfornati dal cuoco in modo da poterli dare alla pagina HTML
import org.springframework.web.bind.annotation.GetMapping; //serve al cameriere per capire cosa vuole il cliente
import org.springframework.web.bind.annotation.PathVariable; //serve a leggere le informazioni variabili dentro al sito internet

import java.util.Optional;


@Controller
public class RoomController {

    //creiamo la variabile cameriere e poi assegnamo questa variabile al cuoco tramite costrutture
    private final RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping("/rooms") //se l'utente digita sul browser www.sit.it/movies, sio attiva qeusto metodo
    public String list(Model model){
        model.addAttribute("rooms", roomService.findAll()); //il cameriere prende la lista di film ricevutra dal cuoco e la appoggia sul suo vassoio | cuoco mi dai tutti i film??
        return "rooms/list";
    }

    //stessa roba ma voglio vedere i dettagli sul film SPECIFICO
    @GetMapping("/rooms/{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Room> room = roomService.findById(id);
        if (room.isEmpty()) {
            return "redirect:/rooms";
        }
        model.addAttribute("room", room.get());
        return "rooms/show";
    }
}