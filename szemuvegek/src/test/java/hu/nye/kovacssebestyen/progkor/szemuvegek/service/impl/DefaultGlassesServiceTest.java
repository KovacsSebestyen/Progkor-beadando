package hu.nye.kovacssebestyen.progkor.szemuvegek.service.impl;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.data.repository.Repository;
import hu.nye.kovacssebestyen.progkor.szemuvegek.service.GlassesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class DefaultGlassesServiceTest {

    @Mock
    private Repository<Glasses, Long> glassesRepository;
    private GlassesService underTest;

    @BeforeEach
    void setUp() {
        underTest = new DefaultGlassesService(glassesRepository);
    }

    @Test
    void createGlasses() {
    }

    @Test
    void getGlassesById() {
    }

    @Test
    void getAllGlasses() {
    }

    @Test
    void updateGlasses() {
    }

    @Test
    void deleteGlassesById() {
    }
}