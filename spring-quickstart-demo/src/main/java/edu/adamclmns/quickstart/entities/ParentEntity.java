package edu.adamclmns.quickstart.entities;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParentEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String displayName;
    private String description;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<ChildEntity> children;

    public ParentEntity(){

    }

    public ParentEntity(String name, String description, List<ChildEntity> children){
        this.displayName = name;
        this.description = description;
        this.children = children;
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

    public List<ChildEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ChildEntity> children) {
        this.children = children;
    }
}
