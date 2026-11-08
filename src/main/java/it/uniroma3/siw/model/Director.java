package it.uniroma3.siw.model;

//importazione degli strumenti che serviranno a jakarta per salvare i dati della classe nel database
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //attributi di un regista
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String nationality;

    //GETTER E SETTER

    //id
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    //name
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    //surname
    public String getSurname(){return surname;}
    public void setSurname(String surname){this.surname = surname;}

    //birthDate
    public LocalDate getBirthDate(){return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    //nationality
    public String getNationality(){return nationality;}
    public void setNationality(String nationality){this.nationality = nationality;}
}
