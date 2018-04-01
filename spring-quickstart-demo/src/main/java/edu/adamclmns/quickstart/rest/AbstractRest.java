package edu.adamclmns.quickstart.rest;

import edu.adamclmns.quickstart.entities.ParentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class AbstractRest<T> {
    private Class<T> t;
    abstract EntityManager getEntityManager();

    protected AbstractRest(Class<T> t){
        this.t = t;
    }

    protected List<T> findAll(){
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(t);
        Root<T> rootEntry = cq.from(t);
        CriteriaQuery<T> cqAll = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(cqAll);
        java.util.List<T> all = allQuery.getResultList();
        em.close();
        return all;
    }

    protected T findbyId(Long id){
        EntityManager em = getEntityManager();
        T found = em.find(t, id);
        em.close();
        return found;
    }

    protected void create(T entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    protected void delete(T entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    protected void delete(Long id){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        T entity = em.find(t, id);
        em.remove(entity);
        em.getTransaction().commit();
    }

    protected void update(T entity){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }
}
