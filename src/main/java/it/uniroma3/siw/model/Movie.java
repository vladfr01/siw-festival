//modulo d'archivio che il NONNO ARCHIVISTA usa per costruire lo scaffale movie in cantina (dove ci saranno i film)

package it.uniroma3.siw.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //variabili di un film
    private String title;
    private Integer year;
    private Integer duration; //minuti
    private String genre;
    @ManyToOne
    private Director director;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Director getDirector(){return director;}
    public void setDirector(Director director){this.director = director;}
}
