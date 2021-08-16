package com.bcp.monitoring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipeTest {
    @Test
    void testCanEqual() {
        assertFalse((new Equipe()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Equipe equipe = new Equipe();

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");
        assertTrue(equipe.canEqual(equipe1));
    }

    @Test
    void testConstructor() {
        Equipe actualEquipe = new Equipe();
        actualEquipe.setId(123L);
        actualEquipe.setName("Name");
        assertEquals(123L, actualEquipe.getId().longValue());
        assertEquals("Name", actualEquipe.getName());
        assertEquals("Equipe(id=123, name=Name)", actualEquipe.toString());
    }

    @Test
    void testEquals() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        assertNotEquals(null, equipe);
    }

    @Test
    void testEquals10() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName(null);

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName(null);
        assertEquals(equipe, equipe1);
        int expectedHashCodeResult = equipe.hashCode();
        assertEquals(expectedHashCodeResult, equipe1.hashCode());
    }

    @Test
    void testEquals2() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        assertNotEquals("Different type to Equipe", equipe);
    }

    @Test
    void testEquals3() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        assertEquals(equipe, equipe);
        int expectedHashCodeResult = equipe.hashCode();
        assertEquals(expectedHashCodeResult, equipe.hashCode());
    }

    @Test
    void testEquals4() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");
        assertEquals(equipe, equipe1);
        int expectedHashCodeResult = equipe.hashCode();
        assertEquals(expectedHashCodeResult, equipe1.hashCode());
    }

    @Test
    void testEquals5() {
        Equipe equipe = new Equipe();
        equipe.setId(0L);
        equipe.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");
        assertNotEquals(equipe, equipe1);

        //////////
        Equipe equipe2 = new Equipe();
        equipe2.setId(null);
        equipe2.setName("Name");

        Equipe equipe3 = new Equipe();
        equipe3.setId(123L);
        equipe3.setName("Name");
        assertNotEquals(equipe2, equipe3);

        ////////
        Equipe equipe4 = new Equipe();
        equipe4.setId(123L);
        equipe4.setName(null);

        Equipe equipe5 = new Equipe();
        equipe5.setId(123L);
        equipe5.setName("Name");
        assertNotEquals(equipe4, equipe5);

        ///////
        Equipe equipe6 = new Equipe();
        equipe6.setId(123L);
        equipe6.setName("com.bcp.monitoring.model.Equipe");

        Equipe equipe7 = new Equipe();
        equipe7.setId(123L);
        equipe7.setName("Name");
        assertNotEquals(equipe6, equipe7);
    }




    @Test
    void testEquals9() {
        Equipe equipe = new Equipe();
        equipe.setId(null);
        equipe.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(null);
        equipe1.setName("Name");
        assertEquals(equipe, equipe1);
        int expectedHashCodeResult = equipe.hashCode();
        assertEquals(expectedHashCodeResult, equipe1.hashCode());
    }
}

