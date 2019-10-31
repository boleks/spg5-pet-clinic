package com.boleks.spg5petclinic.repositories;

import com.boleks.spg5petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
