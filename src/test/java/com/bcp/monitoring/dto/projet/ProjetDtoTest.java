package com.bcp.monitoring.dto.projet;

import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new ProjetDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ProjetDto projetDto = new ProjetDto();

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertTrue(projetDto.canEqual(projetDto1));
    }

    @Test
    void testConstructor() {
        ProjetDto actualProjetDto = new ProjetDto();
        actualProjetDto.setDescription("The characteristics of someone or something");
        actualProjetDto.setEquipe("Equipe");
        actualProjetDto.setId(123L);
        HashSet<Api> apiSet = new HashSet<Api>();
        actualProjetDto.setListAPIs(apiSet);
        actualProjetDto.setName("Name");
        actualProjetDto.setResponsableIt("Responsable It");
        actualProjetDto.setResponsableMetier("Responsable Metier");
        assertEquals("The characteristics of someone or something", actualProjetDto.getDescription());
        assertEquals("Equipe", actualProjetDto.getEquipe());
        assertEquals(123L, actualProjetDto.getId().longValue());
        assertSame(apiSet, actualProjetDto.getListAPIs());
        assertEquals("Name", actualProjetDto.getName());
        assertEquals("Responsable It", actualProjetDto.getResponsableIt());
        assertEquals("Responsable Metier", actualProjetDto.getResponsableMetier());
        assertEquals(
                "ProjetDto(id=123, name=Name, responsableIt=Responsable It, responsableMetier=Responsable Metier,"
                        + " equipe=Equipe, description=The characteristics of someone or something, listAPIs=[])",
                actualProjetDto.toString());
    }

    @Test
    void testEquals() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());
        assertNotEquals(null,projetDto);
    }

    @Test
    void testEquals10() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(null);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals11() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName(null);
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals12() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Responsable It");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals13() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Name");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals14() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt(null);
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals15() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("Name");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals16() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription(null);
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals17() {
        Api api = new Api();
        api.setPort(8080);
        api.setIp("127.0.0.1");
        api.setStatus(true);
        api.setDb(true);
        api.setPing(true);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(true);
        api.setToken("ABC123");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());

        HashSet<Api> apiSet = new HashSet<Api>();
        apiSet.add(api);

        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(apiSet);

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals2() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());
        assertNotEquals("Different type to ProjetDto",projetDto);
    }

    @Test
    void testEquals3() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());
        assertEquals(projetDto,projetDto);
        int expectedHashCodeResult = projetDto.hashCode();
        assertEquals(expectedHashCodeResult, projetDto.hashCode());
    }

    @Test
    void testEquals4() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertEquals(projetDto,projetDto1);
        int expectedHashCodeResult = projetDto.hashCode();
        assertEquals(expectedHashCodeResult, projetDto1.hashCode());
    }

    @Test
    void testEquals5() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Name");
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals6() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier(null);
        projetDto.setEquipe("Equipe");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals7() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Name");
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals8() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe(null);
        projetDto.setId(123L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }

    @Test
    void testEquals9() {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setResponsableMetier("Responsable Metier");
        projetDto.setEquipe("Equipe");
        projetDto.setId(0L);
        projetDto.setName("Name");
        projetDto.setResponsableIt("Responsable It");
        projetDto.setDescription("The characteristics of someone or something");
        projetDto.setListAPIs(new HashSet<Api>());

        ProjetDto projetDto1 = new ProjetDto();
        projetDto1.setResponsableMetier("Responsable Metier");
        projetDto1.setEquipe("Equipe");
        projetDto1.setId(123L);
        projetDto1.setName("Name");
        projetDto1.setResponsableIt("Responsable It");
        projetDto1.setDescription("The characteristics of someone or something");
        projetDto1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDto,projetDto1);
    }
}

