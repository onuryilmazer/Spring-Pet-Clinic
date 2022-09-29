package com.onuryilmazer.springpetclinic.services.map;

import com.onuryilmazer.springpetclinic.model.Owner;
import com.onuryilmazer.springpetclinic.model.Vet;
import com.onuryilmazer.springpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        for (Vet vet : map.values()) {
            if (vet.getLastName().equals(lastName)) {
                return vet;
            }
        }
        return null;
    }
}