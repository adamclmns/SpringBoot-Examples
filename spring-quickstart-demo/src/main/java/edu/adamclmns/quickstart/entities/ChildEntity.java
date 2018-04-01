package edu.adamclmns.quickstart.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChildEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String displayName;
    private String description;

    public ChildEntity(){

    }
    public ChildEntity(String name, String description){
        this.displayName = name;
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
