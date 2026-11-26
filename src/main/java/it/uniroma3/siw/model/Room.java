package it.uniroma3.siw.model;

//importazione degli strumenti che serviranno a jakarta per salvare i dati della classe nel database
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //attributi di una room/sala
    private String name;
    private Integer capacity;
    //un stanza appartiene a un festival
    @ManyToOne
    private Festival festival;

    //GETTER E SETTER

    //id
    public Long getId(){return id;}
    public void setId(long id){this.id = id;}

    //name
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    //capacity
    public Integer getCapacity(){return capacity;}
    public void setCapacity(Integer capacity){this.capacity = capacity;}

    //festival
    public Festival getFestival(){return festival;}
    public void setFestival(Festival festival){this.festival = festival;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) && Objects.equals(festival, room.festival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, festival);
    }
}

