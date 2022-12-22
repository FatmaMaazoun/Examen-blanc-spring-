package tn.esprit.maazounfatmaexamen.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.maazounfatmaexamen.entities.Direction;
import tn.esprit.maazounfatmaexamen.entities.OuevreArt;

import java.util.List;

public interface OeuvreArtService {
    OuevreArt ajouterOeuvreArtEtAffecterAZone(OuevreArt ouevreArt,long idZone);

    List<String> titreTableauParMuseeEtDirection(Long idMusse,Direction direction);
}
