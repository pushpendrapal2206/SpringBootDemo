package com.codility.tasks.hibernate.solution;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class PersonService {

    private final EntityManager entityManager;

    public PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    public void addPet(Long personId, String petName) {
       Person person =  entityManager.find(Person.class, personId);
       if (person == null) {
           throw new PersonNotFoundException();
       }
       Pet pet = new Pet();
       pet.setName(petName);
       pet.setOwner(person);
       person.getPets().add(pet);

       entityManager.persist(person);
    }
}
