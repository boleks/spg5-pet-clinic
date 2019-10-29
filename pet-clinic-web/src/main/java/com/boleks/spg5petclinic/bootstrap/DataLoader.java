package com.boleks.spg5petclinic.bootstrap;

import com.boleks.spg5petclinic.model.Owner;
import com.boleks.spg5petclinic.model.Pet;
import com.boleks.spg5petclinic.model.PetType;
import com.boleks.spg5petclinic.model.Vet;
import com.boleks.spg5petclinic.services.OwnerService;
import com.boleks.spg5petclinic.services.PetTypeService;
import com.boleks.spg5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("Zaplenska 32");
        owner1.setCity("Beograd");
        owner1.setTelephone("381113220100");

        Pet markoPet = new Pet();
        markoPet.setPetType(savedDogType);
        markoPet.setOwner(owner1);
        markoPet.setBirthDate(LocalDate.now());
        markoPet.setName("Dzeki");

        owner1.getPets().add(markoPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Marija");
        owner2.setLastName("Savic");
        owner2.setAddress("Rumenicka 10");
        owner2.setCity("Novi Sad");
        owner2.setTelephone("381215004250");

        Pet marijaMacka = new Pet();
        marijaMacka.setName("Pufnica");
        marijaMacka.setBirthDate(LocalDate.now());
        marijaMacka.setOwner(owner2);
        marijaMacka.setPetType(savedCatType);
        owner2.getPets().add(marijaMacka);

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
