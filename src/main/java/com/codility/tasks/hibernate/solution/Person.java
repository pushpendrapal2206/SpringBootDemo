package com.codility.tasks.hibernate.solution;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;

    public String getFirstName() {
        return firstName;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

