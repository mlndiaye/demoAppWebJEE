package sn.ept.git.dic2.demoappwebjee.services;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sn.ept.git.dic2.demoappwebjee.entities.Departement;

@Singleton
@Startup
public class InitDepartement {

    @PersistenceContext(unitName = "demoAppWebJeePu")
    private EntityManager em;

    @PostConstruct
    public void init(){
        System.out.println("création du département GIT");
        Departement departement = new Departement();
        departement.setCode("GIT");
        departement.setNom("Informatique");
        em.persist(departement);
    }
}
