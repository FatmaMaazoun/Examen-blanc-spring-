package tn.esprit.maazounfatmaexamen.services;

import tn.esprit.maazounfatmaexamen.entities.Zone;

public interface IZoneService {
    public void desaffecterDirecteurZoneInactif();
    Zone ajouterZoneEtAffecterAMusee(Zone zone, long idMusee);
}
