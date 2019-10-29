package com.boleks.spg5petclinic.bootstrap;

import com.boleks.spg5petclinic.model.*;
import com.boleks.spg5petclinic.services.OwnerService;
import com.boleks.spg5petclinic.services.PetTypeService;
import com.boleks.spg5petclinic.services.SpecialtyService;
import com.boleks.spg5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiolog");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Hirurg");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Zubar");
        Speciality savedDentistry = specialtyService.save(dentistry);

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
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Boban");
        vet2.setLastName("Antonic");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}