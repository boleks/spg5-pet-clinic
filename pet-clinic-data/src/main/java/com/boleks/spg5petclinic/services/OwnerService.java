package com.boleks.spg5petclinic.services;

import com.boleks.spg5petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
