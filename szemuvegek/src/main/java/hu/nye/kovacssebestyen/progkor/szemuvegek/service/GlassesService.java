package hu.nye.kovacssebestyen.progkor.szemuvegek.service;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;

import java.util.List;

/**
 * A service-hez szükséges függvények létrehozása.
 */
public interface GlassesService {

    Glasses createGlasses(Glasses glasses);

    Glasses getGlassesById(Long id);

    List<Glasses> getAllGlasses();

    Glasses updateGlasses(Glasses glasses);

    void deleteGlassesById(Long id);
}
