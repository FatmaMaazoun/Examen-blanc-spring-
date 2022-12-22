package tn.esprit.maazounfatmaexamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.maazounfatmaexamen.entities.Personnel;
import tn.esprit.maazounfatmaexamen.entities.Zone;
import tn.esprit.maazounfatmaexamen.repositories.PersonnelRepository;
import tn.esprit.maazounfatmaexamen.repositories.ZoneRepository;

@Service
public class IPersonnelServiceIMP implements  IPersonnelService{

    @Autowired
    PersonnelRepository personnelRepository;

    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public void affecterPersonnelsAZone(Long idZone, Long idGardien, Long idDirecteur) {
        Zone zone=zoneRepository.findById(idZone).orElse(null);
        Personnel gardien=personnelRepository.findById(idGardien).orElse(null);
        Personnel directeur=personnelRepository.findById(idDirecteur).orElse(null);

        if(zone!=null && gardien!=null && directeur!=null){
            gardien.setZoneGardiens(zone);
            personnelRepository.save(gardien);

            zone.setPersonnelDirecteur(directeur);
            zoneRepository.save(zone);



        }
    }
}
