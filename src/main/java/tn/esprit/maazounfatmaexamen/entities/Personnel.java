package tn.esprit.maazounfatmaexamen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersonnel;

    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereAffectation;

    @Enumerated(EnumType.STRING)
    private  TypePersonnel typePersonnel;

    @ManyToOne
    private Zone zoneGardiens;

    @OneToOne(mappedBy = "personnelDirecteur")
    private Zone ZoneDirecteur;
}
