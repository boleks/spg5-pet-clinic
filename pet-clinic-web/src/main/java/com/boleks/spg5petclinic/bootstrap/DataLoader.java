package com.boleks.spg5petclinic.bootstrap;

import com.boleks.spg5petclinic.model.Owner;
import com.boleks.spg5petclinic.model.PetType;
import com.boleks.spg5petclinic.model.Vet;
import com.boleks.spg5petclinic.services.OwnerService;
import com.boleks.spg5petclinic.services.PetTypeService;
import com.boleks.spg5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Marko");
        owner1.setLastName("Nikolic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marija");
        owner2.setLastName("Savic");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Nikola");
        vet1.setLastName("Petrovic");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Boban");
        vet2.setLastName("Antonic");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
