package com.onuryilmazer.springpetclinic.services.map;

import com.onuryilmazer.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected HashMap<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("Object can't be null.");
        }
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf( (Map.Entry<Long, T> entry) -> {return entry.getValue().equals(object);} );
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1L;
        }
        catch (Exception e) {
            nextId = 1L;
        }

        return nextId;
    }
}
