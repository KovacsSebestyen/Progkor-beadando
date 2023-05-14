package hu.nye.kovacssebestyen.progkor.szemuvegek.service.impl;

import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.FrameType;
import hu.nye.kovacssebestyen.progkor.szemuvegek.data.model.Glasses;
import hu.nye.kovacssebestyen.progkor.szemuvegek.data.repository.Repository;
import hu.nye.kovacssebestyen.progkor.szemuvegek.service.GlassesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class DefaultGlassesServiceTest {

    private static final Long testGlassesId = 1L;
    private static final Glasses testGlasses = new Glasses(testGlassesId, "marka", "szin", 1.0, "reteg", 20230514, FrameType.Metal);
    @Mock
    private Repository<Glasses, Long> glassesRepository;
    private GlassesService underTest;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultGlassesService(glassesRepository);
    }

    @Test
    void testCreateGlassesShouldGiveBackGlassesAfterCreatedNewGlasses() {
        //given
        given(glassesRepository.save(testGlasses)).willReturn(testGlasses);

        //when
        Glasses result = underTest.createGlasses(testGlasses);

        //then
        assertThat(result, equalTo(testGlasses));
        verify(glassesRepository).save(testGlasses);
        verifyNoMoreInteractions(glassesRepository);
    }

    @Test
    void testGetGlassesByIdShouldGiveBackThatGlassesWithSameId() {
        //given
        given(glassesRepository.getById(testGlassesId)).willReturn(testGlasses);

        //when
        Glasses result = underTest.getGlassesById(testGlassesId);

        //then
        assertThat(result, equalTo(testGlasses));
        verify(glassesRepository).getById(testGlassesId);
        verifyNoMoreInteractions(glassesRepository);
    }

    @Test
    void testGetAllGlassesShouldGiveBackAListOfGlasses() {
        //given
        given(glassesRepository.getAll()).willReturn(List.of(testGlasses));

        //when
        List<Glasses> result = underTest.getAllGlasses();

        //then
        assertThat(result, equalTo(List.of(testGlasses)));
        verify(glassesRepository).getAll();
        verifyNoMoreInteractions(glassesRepository);
    }

    @Test
    void testUpdateGlassesShouldGiveBackTheValuesOfUpdatedGlasses() {
        //given
        given(glassesRepository.update(testGlasses)).willReturn(testGlasses);

        //when
        Glasses result = underTest.updateGlasses(testGlasses);

        //then
        assertThat(result, equalTo(testGlasses));
        verify(glassesRepository).update(testGlasses);
        verifyNoMoreInteractions(glassesRepository);
    }

    @Test
    void testDeleteGlassesByIdShouldGiveBackNothingOnlyVerifyThatTheFunctionIsCalled() {
        //given

        //when
        underTest.deleteGlassesById(testGlassesId);

        //then
        verify(glassesRepository).deleteById(testGlassesId);
        verifyNoMoreInteractions(glassesRepository);
    }
}