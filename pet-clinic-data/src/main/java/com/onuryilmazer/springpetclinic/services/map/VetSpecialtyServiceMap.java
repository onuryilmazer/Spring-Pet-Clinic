package com.onuryilmazer.springpetclinic.services.map;

import com.onuryilmazer.springpetclinic.model.VetSpecialty;
import com.onuryilmazer.springpetclinic.services.VetSpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetSpecialtyServiceMap extends AbstractMapService<VetSpecialty, Long> implements VetSpecialtyService {
    @Override
    public Set<VetSpecialty> findAll() {
        return super.findAll();
    }

    @Override
    public VetSpecialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return super.save(object);
    }

    @Override
    public void delete(VetSpecialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
