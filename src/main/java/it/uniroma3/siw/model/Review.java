package it.uniroma3.siw.model;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //attributi di review
    private Integer rating;
    private String text;

    //la recensione si puo applicare a u nsolo film
    @ManyToOne
    private Movie movie;

    //GETTER E SETTER
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Integer getRating() {return rating;}
    public void setRating(Integer rating) {this.rating = rating;}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public Movie getMovie() {return movie;}
    public void setMovie(Movie movie) {this.movie = movie;}
}
