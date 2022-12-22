package tn.esprit.maazounfatmaexamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.maazounfatmaexamen.entities.Zone;

import java.util.List;

public interface ZoneRepository extends JpaRepository<Zone,Long> {

    List<Zone> findZonesByActifIsFalse();
}
