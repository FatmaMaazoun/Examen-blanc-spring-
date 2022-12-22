package tn.esprit.maazounfatmaexamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idZone;
    private String code;
    private String libelle;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    private boolean actif;

    @JsonIgnore
    @ManyToOne
    private  Musee musee;


    @OneToMany(mappedBy = "zone")
    List<OuevreArt> ouevreArts;

    @OneToMany(mappedBy = "zoneGardiens")
    List<Personnel> personnelsGardiens;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Personnel personnelDirecteur;
}
