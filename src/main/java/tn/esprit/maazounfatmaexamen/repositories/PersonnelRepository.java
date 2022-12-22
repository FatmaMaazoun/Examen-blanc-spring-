package tn.esprit.maazounfatmaexamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.maazounfatmaexamen.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
}
