package com.boleks.spg5petclinic.repositories;

import com.boleks.spg5petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
