package tn.esprit.maazounfatmaexamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OuevreArt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOeuvreArt;

    private String artiste;
    private String titreTableau;

    @JsonIgnore
    @ManyToOne
    private Zone zone;
}
