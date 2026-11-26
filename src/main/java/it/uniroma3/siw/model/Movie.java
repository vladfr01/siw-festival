//modulo d'archivio che il NONNO ARCHIVISTA usa per costruire lo scaffale movie in cantina (dove ci saranno i film)

package it.uniroma3.siw.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.Objects;

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

    //relazione molit a uno con Director (molti film , un regista)
    @ManyToOne
    private Director director;

    //relazione molti a molti con festivals (ogni festival ha diversi film) -> qui movies fa da riflesso
    @ManyToMany(mappedBy = "movies")
    private List<Festival> festivals;

    //relazione molti a uno con screening(un film puo essere legato a piu proiezioni)
    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings;

    //relazione molti a uno (un film, tante recensioni)
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;


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

    //get e setter della lista festivals
    public List<Festival> getFestivals(){return festivals;}
    public void setFestivals(List<Festival> festivals){this.festivals = festivals;}

    //get e setter della lista screenings
    public List<Screening> getScreenings() {return screenings;}
    public void setScreenings(List<Screening> screenings) {this.screenings = screenings;}

    //get e set della lista reviews
    public List<Review> getReviews() {return reviews;}
    public void setReviews(List<Review> reviews) {this.reviews = reviews;}


    //metodi per evitare doppioni facendo un confronto
    @Override
    public boolean equals(Object o){
        if (this == o) return true;  //stesso biscotto fisico -> uguali
        if (o == null || getClass() != o.getClass()) return false;  // niente, o non e' un Movie -> diversi
        Movie other = (Movie) o;
        return Objects.equals(title, other.title) && Objects.equals(year, other.year);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, year);
    }

}
