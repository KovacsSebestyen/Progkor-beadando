package hu.nye.kovacssebestyen.progkor.szemuvegek.data.repository.impl;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class InMemoryGlassesRepository implements Repository<Glasses, Long> {

    private static final Map<Long, Glasses> STORAGE = new HashMap<>();

    @Override
    public Glasses save(Glasses glasses) {
        Long id = STORAGE.size() + 1L;
        glasses.setId(id);
        STORAGE.put(id, glasses);
        return STORAGE.get(id);
    }

    @Override
    public Glasses getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Glasses> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Glasses update(Glasses glasses) {
        Long id = glasses.getId();
        STORAGE.put(id, glasses);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
