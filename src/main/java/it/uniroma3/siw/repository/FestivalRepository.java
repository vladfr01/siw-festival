package it.uniroma3.siw.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import it.uniroma3.siw.model.Festival;
import java.util.List;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
    //il magazziniere impara la richiesta (trova tutti i festival di cannes)
    List<Festival> findByCityContainingIgnoreCase(String city);

}
