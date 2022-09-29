package com.onuryilmazer.springpetclinic.services;

import com.onuryilmazer.springpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
