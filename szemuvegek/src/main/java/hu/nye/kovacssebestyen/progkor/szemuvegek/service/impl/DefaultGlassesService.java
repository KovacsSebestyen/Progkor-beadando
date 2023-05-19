package hu.nye.kovacssebestyen.progkor.szemuvegek.service.impl;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.service.GlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import hu.nye.kovacssebestyen.progkor.szemuvegek.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A GlassesService interface-ben magadott függvények implementálása.
 */
@Service
public class DefaultGlassesService implements GlassesService {

    private final Repository<Glasses, Long> glassesRepository;

    @Autowired
    public DefaultGlassesService(Repository<Glasses, Long> glassesRepository) {
        this.glassesRepository = glassesRepository;
    }

    @Override
    public Glasses createGlasses(Glasses glasses) {
        return glassesRepository.save(glasses);
    }

    @Override
    public Glasses getGlassesById(Long id) {
        return glassesRepository.getById(id);
    }

    @Override
    public List<Glasses> getAllGlasses() {
        return glassesRepository.getAll();
    }

    @Override
    public Glasses updateGlasses(Glasses glasses) {
        return glassesRepository.update(glasses);
    }

    @Override
    public void deleteGlassesById(Long id) {
        glassesRepository.deleteById(id);
    }
}
