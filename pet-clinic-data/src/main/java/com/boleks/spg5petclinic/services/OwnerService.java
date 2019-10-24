package com.boleks.spg5petclinic.services;

import com.boleks.spg5petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
