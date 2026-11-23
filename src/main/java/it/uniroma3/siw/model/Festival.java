package it.uniroma3.siw.model;
//importazione degli strumenti che serviranno a jakarta per salvare i dati della classe nel database

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

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


}

