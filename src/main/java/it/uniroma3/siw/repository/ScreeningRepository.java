//NONNO ARCHIVISTA: trova i film senza che tu scriva SQL
//AIUTO CUOCO che va negli scaffali a prendere quello di cui il cuoco ha bisogno

package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query("select s from Screening s where s.room.festival.id = :festivalId order by s.startTime")
    List<Screening> findByFestivalOrdered(@Param("festivalId") Long festivalId);
}