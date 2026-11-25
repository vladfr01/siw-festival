//NONNO ARCHIVISTA: trova i film senza che tu scriva SQL
//AIUTO CUOCO che va negli scaffali a prendere quello di cui il cuoco ha bisogno

package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Movie;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m left join fetch m.director")
    List<Movie> findAllWithDirector();
}