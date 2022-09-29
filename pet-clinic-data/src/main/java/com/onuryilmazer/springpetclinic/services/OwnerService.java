package com.onuryilmazer.springpetclinic.services;

import com.onuryilmazer.springpetclinic.model.Owner;
import java.util.Set;

public interface OwnerService extends CrudInterface<Owner, Long> {
    Owner findByLastName(String lastName);
}
