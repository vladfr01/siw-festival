package it.uniroma3.siw.model;
//importazione degli strumenti che serviranno a jakarta per salvare i dati della classe nel database

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //attributi del Festival
    private String name;
    private String city;
    private String edition;
    private LocalDate startDate;
    private LocalDate endDate;

    //un festival ha diverse sale dove proiettare i film
    @OneToMany(mappedBy = "festival")
    private List<Room> rooms;

    //creo la tabella della relazione molti a molti tra movies e festivals
    @ManyToMany
    @JoinTable(name = "festival_movie",
        joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies; // la lista dei film di questo festival

    //GETTER E SETTER

    //id
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    //name
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    //city
    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}

    //edition
    public String getEdition(){return edition;}
    public void setEdition(String edition){this.edition = edition;}

    //startDate
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate startDate){this.startDate = startDate;}

    //endDate
    public LocalDate getEndDate(){return endDate;}
    public void setEndDate(LocalDate endDate){this.endDate = endDate;}

    //movies
    public List<Movie> getMovies(){return movies;}
    public void setMovies(List<Movie> movies){this.movies = movies;}

    //rooms
    public List<Room> getRooms(){return rooms;}
    public void setRooms(List<Room> rooms){this.rooms = rooms;}
}

