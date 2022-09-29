package com.onuryilmazer.springpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {
    protected HashMap<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf( (Map.Entry<ID, T> entry) -> {return entry.getValue().equals(object);} );
    }

    void deleteById(ID id) {
        map.remove(id);
    }
}
