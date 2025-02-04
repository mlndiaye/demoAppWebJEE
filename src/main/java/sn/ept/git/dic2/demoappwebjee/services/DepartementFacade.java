package sn.ept.git.dic2.demoappwebjee.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sn.ept.git.dic2.demoappwebjee.entities.Departement;

@Stateless
public class DepartementFacade {
    @PersistenceContext(unitName = "demoAppWebJeePu")
    private EntityManager em;

    public void createDepartement(Departement departement) {
        em.persist(departement);
    }
}
