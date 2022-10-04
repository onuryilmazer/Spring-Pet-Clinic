package com.onuryilmazer.springpetclinic.bootstrap;

import com.onuryilmazer.springpetclinic.model.Owner;
import com.onuryilmazer.springpetclinic.model.Pet;
import com.onuryilmazer.springpetclinic.services.OwnerService;
import com.onuryilmazer.springpetclinic.model.PetType;
import com.onuryilmazer.springpetclinic.services.PetService;
import com.onuryilmazer.springpetclinic.services.PetTypeService;
import com.onuryilmazer.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.onuryilmazer.springpetclinic.model.Vet;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        System.out.println("Data initializer bean created.");
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        owner1.setAddress("Long St. 1");
        owner1.setCity("Miami");
        owner1.setTelephone("1122334455");
        owner1 = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Max");
        owner2.setLastName("Mustermann");
        owner2.setAddress("Musterstrasse 1");
        owner2.setCity("Musterstadt");
        owner2.setTelephone("1122345");
        owner2 = ownerService.save(owner2);

        System.out.println("Owners loaded.");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ali");
        vet1.setLastName("Veli");
        vet1 = vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ayse");
        vet2.setLastName("Merve");
        vet2 = vetService.save(vet2);

        System.out.println("Veterinarians loaded.");

        PetType typeBird = new PetType();
        typeBird.setName("Bird");
        typeBird = petTypeService.save(typeBird);

        PetType typeCat = new PetType();
        typeCat.setName("Cat");
        typeCat = petTypeService.save(typeCat);

        PetType typeDog = new PetType();
        typeDog.setName("Dog");
        typeDog = petTypeService.save(typeDog);

        System.out.println("Pet types created.");

        Pet dog1 = new Pet();
        dog1.setPetType(typeDog);
        dog1.setName("Karabash");
        dog1.setBirthDate(LocalDate.of(2020, 01, 01));
        dog1.setOwner(owner1);
        owner1.getPets().add(dog1);
        owner1 = ownerService.save(owner1);

        Pet cat1 = new Pet();
        cat1.setPetType(typeCat);
        cat1.setName("Tekir");
        cat1.setBirthDate(LocalDate.of(2021, 01, 01));
        cat1.setOwner(owner2);
        owner2.getPets().add(cat1);
        owner2 = ownerService.save(owner2);

        Pet lizard = new Pet();
        PetType typeLizard = new PetType();  //OwnerServiceMap saves new Pets and PetTypes without ID values to their respective ServiceMap implementations.
        typeLizard.setName("Lizard");
        lizard.setPetType(typeLizard);
        lizard.setName("Lizzy");
        lizard.setBirthDate(LocalDate.now());
        lizard.setOwner(owner2);
        owner2.getPets().add(lizard);
        owner2 = ownerService.save(owner2);

        System.out.println("Pets added.");
    }
}
