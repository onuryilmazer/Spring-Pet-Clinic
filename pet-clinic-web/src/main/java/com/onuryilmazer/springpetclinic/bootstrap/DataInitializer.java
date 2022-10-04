package com.onuryilmazer.springpetclinic.bootstrap;

import com.onuryilmazer.springpetclinic.model.Owner;
import com.onuryilmazer.springpetclinic.services.OwnerService;
import com.onuryilmazer.springpetclinic.model.PetType;
import com.onuryilmazer.springpetclinic.services.PetTypeService;
import com.onuryilmazer.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.onuryilmazer.springpetclinic.model.Vet;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        System.out.println("Data initializer bean created.");
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Max");
        owner2.setLastName("Mustermann");
        ownerService.save(owner2);

        System.out.println("Owners loaded.");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ali");
        vet1.setLastName("Veli");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ayse");
        vet2.setLastName("Merve");
        vetService.save(vet2);

        System.out.println("Veterinarians loaded.");

        PetType type1 = new PetType();
        type1.setName("Bird");
        petTypeService.save(type1);

        PetType type2 = new PetType();
        type2.setName("Cat");
        petTypeService.save(type2);

        PetType type3 = new PetType();
        type3.setName("Dog");
        petTypeService.save(type3);

        System.out.println("Pet types loaded.");

    }
}
