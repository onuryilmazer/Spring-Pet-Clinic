package com.onuryilmazer.springpetclinic.services;

import com.onuryilmazer.springpetclinic.model.Vet;
import java.util.Set;

public interface VetService extends CrudInterface<Vet, Long> {
    Vet findByLastName(String lastName);
}
