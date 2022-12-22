package tn.esprit.maazounfatmaexamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.maazounfatmaexamen.entities.Musee;
import tn.esprit.maazounfatmaexamen.repositories.MuseeRepository;

@Service
public class IMuseeServiceIMP implements  IMuseeService{
    @Autowired
    MuseeRepository museeRepository;

    @Override
    public Musee ajouterMusee(Musee musee) {
       return  museeRepository.save(musee);

    }
}
