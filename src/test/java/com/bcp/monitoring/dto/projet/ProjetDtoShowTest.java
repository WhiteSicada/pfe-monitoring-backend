package com.bcp.monitoring.dto.projet;

import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetDtoShowTest {
    @Test
    void testCanEqual() {
        assertFalse((new ProjetDtoShow()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertTrue(projetDtoShow.canEqual(projetDtoShow1));
    }

    @Test
    void testConstructor() {
        ProjetDtoShow actualProjetDtoShow = new ProjetDtoShow();
        actualProjetDtoShow.setDescription("The characteristics of someone or something");
        actualProjetDtoShow.setEquipe("Equipe");
        actualProjetDtoShow.setId(123L);
        HashSet<Api> apiSet = new HashSet<Api>();
        actualProjetDtoShow.setListAPIs(apiSet);
        actualProjetDtoShow.setName("Name");
        actualProjetDtoShow.setResponsableIt("Responsable It");
        actualProjetDtoShow.setResponsableMetier("Responsable Metier");
        assertEquals("The characteristics of someone or something", actualProjetDtoShow.getDescription());
        assertEquals("Equipe", actualProjetDtoShow.getEquipe());
        assertEquals(123L, actualProjetDtoShow.getId().longValue());
        assertSame(apiSet, actualProjetDtoShow.getListAPIs());
        assertEquals("Name", actualProjetDtoShow.getName());
        assertEquals("Responsable It", actualProjetDtoShow.getResponsableIt());
        assertEquals("Responsable Metier", actualProjetDtoShow.getResponsableMetier());
        assertEquals(
                "ProjetDtoShow(id=123, name=Name, responsableIt=Responsable It, responsableMetier=Responsable Metier,"
                        + " equipe=Equipe, description=The characteristics of someone or something, listAPIs=[])",
                actualProjetDtoShow.toString());
    }

    @Test
    void testEquals() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());
        assertNotEquals(null,projetDtoShow);
    }

    @Test
    void testEquals10() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(null);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals11() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName(null);
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals12() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Responsable It");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals13() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Name");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals14() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt(null);
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals15() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("Name");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals16() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription(null);
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
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

        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(apiSet);

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals2() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());
        assertNotEquals("Different type to ProjetDtoShow",projetDtoShow);
    }

    @Test
    void testEquals3() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());
        assertEquals(projetDtoShow,projetDtoShow);
        int expectedHashCodeResult = projetDtoShow.hashCode();
        assertEquals(expectedHashCodeResult, projetDtoShow.hashCode());
    }

    @Test
    void testEquals4() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertEquals(projetDtoShow,projetDtoShow1);
        int expectedHashCodeResult = projetDtoShow.hashCode();
        assertEquals(expectedHashCodeResult, projetDtoShow1.hashCode());
    }

    @Test
    void testEquals5() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Name");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals6() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier(null);
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals7() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Name");
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals8() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe(null);
        projetDtoShow.setId(123L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }

    @Test
    void testEquals9() {
        ProjetDtoShow projetDtoShow = new ProjetDtoShow();
        projetDtoShow.setResponsableMetier("Responsable Metier");
        projetDtoShow.setEquipe("Equipe");
        projetDtoShow.setId(0L);
        projetDtoShow.setName("Name");
        projetDtoShow.setResponsableIt("Responsable It");
        projetDtoShow.setDescription("The characteristics of someone or something");
        projetDtoShow.setListAPIs(new HashSet<Api>());

        ProjetDtoShow projetDtoShow1 = new ProjetDtoShow();
        projetDtoShow1.setResponsableMetier("Responsable Metier");
        projetDtoShow1.setEquipe("Equipe");
        projetDtoShow1.setId(123L);
        projetDtoShow1.setName("Name");
        projetDtoShow1.setResponsableIt("Responsable It");
        projetDtoShow1.setDescription("The characteristics of someone or something");
        projetDtoShow1.setListAPIs(new HashSet<Api>());
        assertNotEquals(projetDtoShow,projetDtoShow1);
    }
}

