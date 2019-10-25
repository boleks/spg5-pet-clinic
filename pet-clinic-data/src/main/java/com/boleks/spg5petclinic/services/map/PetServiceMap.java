package com.boleks.spg5petclinic.services.map;

import com.boleks.spg5petclinic.model.Pet;
import com.boleks.spg5petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.deleteById(object.getId());

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


}