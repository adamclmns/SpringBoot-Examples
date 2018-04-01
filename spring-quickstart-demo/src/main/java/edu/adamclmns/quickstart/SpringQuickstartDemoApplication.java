package edu.adamclmns.quickstart;

import edu.adamclmns.quickstart.entities.ChildEntity;
import edu.adamclmns.quickstart.entities.ParentEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringQuickstartDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringQuickstartDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadDataForEmbeddedDB(EntityManagerFactory emf){
        return (args)->{
            ChildEntity child1 = new ChildEntity("Child 1","Sampel Child Data Object");
            ChildEntity child2 = new ChildEntity("Child 2","Sample Child Data Object");
            ChildEntity child3 = new ChildEntity("Child 3","Sample Child Data Object");
            ChildEntity child4 = new ChildEntity("Child 4","Sample Child Data Object");

            List<ChildEntity> list1 = new ArrayList<>();
            list1.add(child1);
            list1.add(child2);

            List<ChildEntity> list2 = new ArrayList<>();
            list2.add(child3);
            list2.add(child4);

            List<ChildEntity> list3 = new ArrayList<>();
            list3.add(child1);
            list3.add(child2);
            list3.add(child4);


            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(child1);
                em.persist(child2);
                em.persist(child3);
                em.persist(child4);
                em.persist(new ParentEntity("Parent1", "Sample Parent Data Object", list1));
                em.persist(new ParentEntity("Parent2", "Sample Parent Data Object", list2));
                em.persist(new ParentEntity("A new parent", "A new decription",list3));
                em.getTransaction().commit();
            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                em.close();
            }
        };
    }
}
