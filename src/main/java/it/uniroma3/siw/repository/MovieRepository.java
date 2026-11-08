//NONNO ARCHIVISTA: trova i film senza che tu scriva SQL
//AIUTO CUOCO che va negli scaffali a prendere quello di cui il cuoco ha bisogno

package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.siw.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}