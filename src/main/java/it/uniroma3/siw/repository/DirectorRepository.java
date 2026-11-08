//NONNO archivista: trova tutti i registi senza che tu scriva sql

package it.uniroma3.siw.repository;

//importo i tools che serviaranno all'iternface di fare tutto da solo dal framework di spring
import org.springframework.data.jpa.repository.JpaRepository;

//salvo nella rubrica dei contatti Director cosi che non debba ogni volta scrivere it.uniroma3.siw.model.Director
import it.uniroma3.siw.model.Director;

//do in pasto la classe/entita' Director alla interface DirectorRepository
public interface DirectorRepository extends JpaRepository<Director , Long>{

}


