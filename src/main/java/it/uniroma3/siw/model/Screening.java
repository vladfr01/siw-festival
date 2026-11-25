package it.uniroma3.siw.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime startTime;

    //la proiezione proietta UN FILM
    @ManyToOne
    private Movie movie;

    //la proiezione viene fatta in una sala
    @ManyToOne
    private Room room;

    //GETTER E SETTER
    //id
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    //orario
    public LocalDateTime getStartTime() {return startTime;}
    public void setStartTime(LocalDateTime startTime) {this.startTime = startTime;}

    //film
    public Movie getMovie() {return movie;}
    public void setMovie(Movie movie) {this.movie = movie;}

    //sala
    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room;}
}
