package tn.esprit.maazounfatmaexamen.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.maazounfatmaexamen.entities.Musee;
import tn.esprit.maazounfatmaexamen.entities.Zone;
import tn.esprit.maazounfatmaexamen.repositories.MuseeRepository;
import tn.esprit.maazounfatmaexamen.repositories.ZoneRepository;

import javax.transaction.Transactional;
import java.util.List;
@Slf4j
@Service
public class IZoneServiceIMP implements IZoneService {
    @Autowired
    ZoneRepository zoneRepository;
    @Autowired
    MuseeRepository museeRepository;

    @Transactional
    @Override
    public Zone ajouterZoneEtAffecterAMusee(Zone zone, long idMusee) {
        Musee musee=museeRepository.findById(idMusee).orElse(null);

        if(musee!=null){
            Zone zone1=zoneRepository.save(zone);
            zone1.setMusee(musee);
            return  zone1;
        }return null;

    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    @Override
    public void desaffecterDirecteurZoneInactif() {
        List<Zone> zoneList=zoneRepository.findZonesByActifIsFalse();
        zoneList.stream().forEach(zone -> {zone.setPersonnelDirecteur(null);
            log.info("*******"+zone.getCode());}

        );

    }
}
