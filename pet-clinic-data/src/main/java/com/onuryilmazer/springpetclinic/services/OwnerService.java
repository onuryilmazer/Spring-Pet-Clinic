package com.onuryilmazer.springpetclinic.services;

import com.onuryilmazer.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
