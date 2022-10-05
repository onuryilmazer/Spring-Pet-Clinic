package com.onuryilmazer.springpetclinic.services.map;

import com.onuryilmazer.springpetclinic.model.Vet;
import com.onuryilmazer.springpetclinic.services.VetService;
import com.onuryilmazer.springpetclinic.services.VetSpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final VetSpecialtyService vetSpecialtyService;

    public VetServiceMap(VetSpecialtyService vetSpecialtyService) {
        this.vetSpecialtyService = vetSpecialtyService;
    }

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
        object.getSpecialties().forEach(specialty -> {
            if (specialty.getId() == null) {
                specialty = vetSpecialtyService.save(specialty);
            }
        });

        return super.save(object);
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
