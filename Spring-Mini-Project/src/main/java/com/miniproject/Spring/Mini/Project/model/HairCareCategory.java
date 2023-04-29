package com.miniproject.Spring.Mini.Project.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class HairCareCategory {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HairCareCategory() {
    }

    public HairCareCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    @OneToMany(mappedBy = "hairCareCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accessories> accessoriesList = new ArrayList<>();

    public List<Accessories> getAccessoriesList() {
        return accessoriesList;
    }

    public void setAccessoriesList(List<Accessories> accessoriesList) {
        this.accessoriesList = accessoriesList;
    }

    @Override
    public String toString() {
        return "HairCareCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
