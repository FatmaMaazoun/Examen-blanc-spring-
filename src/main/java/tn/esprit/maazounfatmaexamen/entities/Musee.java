package tn.esprit.maazounfatmaexamen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Musee implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMusee;

    @Temporal(TemporalType.DATE)
    private Date dataUnauguration;
    private String designation ;

    private String adresse;

    @OneToMany(mappedBy = "musee")
    List<Zone> zones;


}
