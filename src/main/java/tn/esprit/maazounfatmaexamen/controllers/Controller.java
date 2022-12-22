package tn.esprit.maazounfatmaexamen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.maazounfatmaexamen.entities.*;
import tn.esprit.maazounfatmaexamen.services.IMuseeService;
import tn.esprit.maazounfatmaexamen.services.IPersonnelService;
import tn.esprit.maazounfatmaexamen.services.IZoneService;
import tn.esprit.maazounfatmaexamen.services.OeuvreArtService;

import java.util.List;

@RestController
@RequestMapping("/examen")
public class Controller {
    @Autowired
    IMuseeService museeService;

    @Autowired
    IZoneService zoneService;

    @Autowired
    OeuvreArtService oeuvreArtService;

    @Autowired
    IPersonnelService personnelService;

    @PostMapping("/musee")
    public Musee ajouterMusee( @RequestBody Musee musee){
        return  museeService.ajouterMusee(musee);
    }

    @PostMapping("/zone/{idmusee}")
    public Zone ajouterZoneEtAffecterAMusee(@RequestBody Zone zone, @PathVariable long idmusee){
        return  zoneService.ajouterZoneEtAffecterAMusee(zone,idmusee);
    }

    @PostMapping("/oeuvreart/{idZone}")
    public OuevreArt ajouterOeuvreArtEtAffecterAZone(@RequestBody OuevreArt ouevreArt,@PathVariable long idZone){
        return  oeuvreArtService.ajouterOeuvreArtEtAffecterAZone(ouevreArt,idZone);

    }

    @PostMapping("/personnel/{idZone}/{idGardien}/{idDirecteur}")
    public void affecterPersonnelsAZone(@PathVariable Long idZone,@PathVariable Long idGardien,@PathVariable Long idDirecteur) {
        personnelService.affecterPersonnelsAZone(idZone,idGardien,idDirecteur);
    }
    @GetMapping("/oeuvreart/titre/{idMusse}/{direction}")
    public List<String> titreTableauParMuseeEtDirection(@PathVariable long idMusse, @PathVariable Direction direction) {
        return  oeuvreArtService.titreTableauParMuseeEtDirection(idMusse,direction);
    }




    }
