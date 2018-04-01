package edu.adamclmns.quickstart.rest;

import edu.adamclmns.quickstart.entities.ChildEntity;
import edu.adamclmns.quickstart.entities.ParentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@RequestMapping("resources/parents")
public class ParentRest extends AbstractRest<ParentEntity> {

    public ParentRest(){
        super(ParentEntity.class);
    }

    @Autowired
    EntityManagerFactory emf;



    @Override
    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public List<ParentEntity> findAll(){
      return super.findAll();
    }

    @RequestMapping(path="{id}", method=RequestMethod.GET)
    public ParentEntity findbyId(@RequestParam Long id){
        return super.findbyId(id);
    }
}
