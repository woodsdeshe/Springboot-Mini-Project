package com.miniproject.Spring.Mini.Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "accessories")
public class Accessories {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String rating;

    public Accessories() {
    }

    public Accessories(Long id, String name, String description, String rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public HairCareCategory getHairCareCategory() {
        return hairCareCategory;
    }

    public void setHairCareCategory(HairCareCategory hairCareCategory) {
        this.hairCareCategory = hairCareCategory;
    }

    @ManyToOne
    @JoinColumn(name = "hair_care_category_id")
    private HairCareCategory hairCareCategory;

    @Override
    public String toString() {
        return "Accessories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
