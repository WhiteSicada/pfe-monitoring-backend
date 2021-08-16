package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.dto.projet.ProjetDto;
import com.bcp.monitoring.dto.projet.ProjetDtoShow;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Equipe;
import com.bcp.monitoring.model.Projet;
import com.bcp.monitoring.model.ResponsableIt;
import com.bcp.monitoring.model.ResponsableMetier;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.EquipeRepository;
import com.bcp.monitoring.repository.ResponsableItRepository;
import com.bcp.monitoring.repository.ResponsableMetierRepository;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjetConvertor.class})
@ExtendWith(SpringExtension.class)
class ProjetConvertorTest {
    @MockBean
    private ApiRepository apiRepository;

    @MockBean
    private EquipeRepository equipeRepository;

    @Autowired
    private ProjetConvertor projetConvertor;

    @MockBean
    private ResponsableItRepository responsableItRepository;

    @MockBean
    private ResponsableMetierRepository responsableMetierRepository;

    @Test
    void testEntityToDto() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        Projet projet = new Projet();
        projet.setResponsableMetier(responsableMetier);
        projet.setApis(new HashSet<Api>());
        projet.setEquipe(equipe);
        projet.setId(123L);
        projet.setName("Name");
        projet.setDescription("The characteristics of someone or something");
        projet.setResponsableIt(responsableIt);
        ProjetDtoShow actualEntityToDtoResult = this.projetConvertor.entityToDto(projet);
        assertEquals("The characteristics of someone or something", actualEntityToDtoResult.getDescription());
        assertEquals("Name", actualEntityToDtoResult.getResponsableMetier());
        assertEquals("Name", actualEntityToDtoResult.getResponsableIt());
        assertEquals("Name", actualEntityToDtoResult.getName());
        assertTrue(actualEntityToDtoResult.getListAPIs().isEmpty());
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
        assertEquals("Name", actualEntityToDtoResult.getEquipe());
    }

    @Test
    void testEntitysToDtos() {
        assertTrue(this.projetConvertor.entitysToDtos(new ArrayList<Projet>()).isEmpty());
    }

    @Test
    void testEntitysToDtos2() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        Projet projet = new Projet();
        projet.setResponsableMetier(responsableMetier);
        projet.setApis(new HashSet<Api>());
        projet.setEquipe(equipe);
        projet.setId(123L);
        projet.setName("Name");
        projet.setDescription("The characteristics of someone or something");
        projet.setResponsableIt(responsableIt);

        ArrayList<Projet> projetList = new ArrayList<Projet>();
        projetList.add(projet);
        assertEquals(1, this.projetConvertor.entitysToDtos(projetList).size());
    }

    @Test
    void testEntitysToDtos3() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        Projet projet = new Projet();
        projet.setResponsableMetier(responsableMetier);
        projet.setApis(new HashSet<Api>());
        projet.setEquipe(equipe);
        projet.setId(123L);
        projet.setName("Name");
        projet.setDescription("The characteristics of someone or something");
        projet.setResponsableIt(responsableIt);

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");

        Projet projet1 = new Projet();
        projet1.setResponsableMetier(responsableMetier1);
        projet1.setApis(new HashSet<Api>());
        projet1.setEquipe(equipe1);
        projet1.setId(123L);
        projet1.setName("Name");
        projet1.setDescription("The characteristics of someone or something");
        projet1.setResponsableIt(responsableIt1);

        ArrayList<Projet> projetList = new ArrayList<Projet>();
        projetList.add(projet1);
        projetList.add(projet);
        assertEquals(2, this.projetConvertor.entitysToDtos(projetList).size());
    }

    @Test
    void testDtoToEntity() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        Optional<ResponsableMetier> ofResult = Optional.<ResponsableMetier>of(responsableMetier);
        when(this.responsableMetierRepository.findByName(anyString())).thenReturn(ofResult);

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        Optional<ResponsableIt> ofResult1 = Optional.<ResponsableIt>of(responsableIt);
        when(this.responsableItRepository.findByName(anyString())).thenReturn(ofResult1);

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        Optional<Equipe> ofResult2 = Optional.<Equipe>of(equipe);
        when(this.equipeRepository.findByName(anyString())).thenReturn(ofResult2);

        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");

        Projet projet = new Projet();
        projet.setResponsableMetier(responsableMetier1);
        projet.setApis(new HashSet<Api>());
        projet.setEquipe(equipe1);
        projet.setId(123L);
        projet.setName("Name");
        projet.setDescription("The characteristics of someone or something");
        projet.setResponsableIt(responsableIt1);
        assertTrue(this.projetConvertor.dtoToEntity(projetDto, projet));
        verify(this.responsableMetierRepository).findByName(anyString());
        verify(this.responsableItRepository).findByName(anyString());
        verify(this.equipeRepository).findByName(anyString());
        Set<Api> expectedApis = projetDto.getListAPIs();
        assertSame(expectedApis, projet.getApis());
        assertEquals(responsableMetier1, projet.getResponsableMetier());
        assertEquals(responsableIt1, projet.getResponsableIt());
        assertEquals("The characteristics of someone or something", projet.getDescription());
        assertEquals("Name", projet.getName());
        assertEquals(equipe1, projet.getEquipe());
    }

    @Test
    void testDtoToEntity2() {
        when(this.responsableMetierRepository.findByName(anyString())).thenReturn(null);
        when(this.responsableItRepository.findByName(anyString())).thenReturn(Optional.<ResponsableIt>empty());

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        Optional<Equipe> ofResult = Optional.<Equipe>of(equipe);
        when(this.equipeRepository.findByName(anyString())).thenReturn(ofResult);

        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        Projet projet = new Projet();
        projet.setResponsableMetier(responsableMetier);
        projet.setApis(new HashSet<Api>());
        projet.setEquipe(equipe1);
        projet.setId(123L);
        projet.setName("Name");
        projet.setDescription("The characteristics of someone or something");
        projet.setResponsableIt(responsableIt);
        assertFalse(this.projetConvertor.dtoToEntity(projetDto, projet));
        verify(this.responsableMetierRepository).findByName(anyString());
        verify(this.responsableItRepository).findByName(anyString());
        verify(this.equipeRepository).findByName(anyString());
    }

    @Test
    void testDtoToEntity3() {
        when(this.responsableMetierRepository.findByName(anyString())).thenReturn(Optional.<ResponsableMetier>empty());

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        Optional<ResponsableIt> ofResult = Optional.<ResponsableIt>of(responsableIt);
        when(this.responsableItRepository.findByName(anyString())).thenReturn(ofResult);

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        Optional<Equipe> ofResult1 = Optional.<Equipe>of(equipe);
        when(this.equipeRepository.findByName(anyString())).thenReturn(ofResult1);

        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");

        Projet projet = new Projet();
        projet.setResponsableMetier(responsableMetier);
        projet.setApis(new HashSet<Api>());
        projet.setEquipe(equipe1);
        projet.setId(123L);
        projet.setName("Name");
        projet.setDescription("The characteristics of someone or something");
        projet.setResponsableIt(responsableIt1);
        assertFalse(this.projetConvertor.dtoToEntity(projetDto, projet));
        verify(this.responsableMetierRepository).findByName(anyString());
        verify(this.responsableItRepository).findByName(anyString());
        verify(this.equipeRepository).findByName(anyString());
    }
}

