package edu.adamclmns.quickstart.rest;

import edu.adamclmns.quickstart.entities.ChildEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@RequestMapping("resources/children")
public class ChildRest extends AbstractRest<ChildEntity> {
    @Autowired
    EntityManagerFactory emf;


    public ChildRest(){
        super(ChildEntity.class);
    }

    @Override
    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public List<ChildEntity> findAll(){
        return super.findAll();

    }

    @RequestMapping(path="{id}", method=RequestMethod.GET)
    public ChildEntity findById(@RequestParam("id") Long id){
        EntityManager em = emf.createEntityManager();
        ChildEntity found = em.find(ChildEntity.class,id);
        em.close();
        return found;
    }


}
