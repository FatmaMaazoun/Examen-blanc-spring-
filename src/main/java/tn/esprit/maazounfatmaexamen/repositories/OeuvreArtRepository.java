package tn.esprit.maazounfatmaexamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.maazounfatmaexamen.entities.Direction;
import tn.esprit.maazounfatmaexamen.entities.OuevreArt;

import java.util.List;

public interface OeuvreArtRepository extends JpaRepository<OuevreArt,Long> {
    @Query("select o.titreTableau from OuevreArt o where o.zone.musee.idMusee= :idMusse and o.zone.direction= :direction")
    List<String>titreTableauxParMuseeEtDirection(@Param("idMusse") Long idMusse,@Param("direction") Direction direction);
}
