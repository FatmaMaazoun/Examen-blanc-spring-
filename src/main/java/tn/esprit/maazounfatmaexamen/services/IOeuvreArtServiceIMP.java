package tn.esprit.maazounfatmaexamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.maazounfatmaexamen.entities.Direction;
import tn.esprit.maazounfatmaexamen.entities.OuevreArt;
import tn.esprit.maazounfatmaexamen.entities.Zone;
import tn.esprit.maazounfatmaexamen.repositories.OeuvreArtRepository;
import tn.esprit.maazounfatmaexamen.repositories.ZoneRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IOeuvreArtServiceIMP implements  OeuvreArtService{
    @Autowired
    OeuvreArtRepository oeuvreArtRepository;

    @Autowired
    ZoneRepository zoneRepository;

    @Transactional
    @Override
    public OuevreArt ajouterOeuvreArtEtAffecterAZone(OuevreArt ouevreArt, long idZone) {
        Zone zone=zoneRepository.findById(idZone).orElse(null);

        if(zone!=null){
            OuevreArt ouevreArt1=oeuvreArtRepository.save(ouevreArt);
            ouevreArt1.setZone(zone);
            return  ouevreArt1;

        }
        return  null;
    }

    @Override
    public List<String> titreTableauParMuseeEtDirection(Long idMusse, Direction direction) {
        return oeuvreArtRepository.titreTableauxParMuseeEtDirection(idMusse,direction);
    }
}
