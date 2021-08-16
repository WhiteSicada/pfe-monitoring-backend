package com.bcp.monitoring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsableMetierTest {
    @Test
    void testCanEqual() {
        assertFalse((new ResponsableMetier()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ResponsableMetier responsableMetier = new ResponsableMetier();

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");
        assertTrue(responsableMetier.canEqual(responsableMetier1));
    }

    @Test
    void testConstructor() {
        ResponsableMetier actualResponsableMetier = new ResponsableMetier();
        actualResponsableMetier.setEmail("jane.doe@example.org");
        actualResponsableMetier.setId(123L);
        actualResponsableMetier.setName("Name");
        assertEquals("jane.doe@example.org", actualResponsableMetier.getEmail());
        assertEquals(123L, actualResponsableMetier.getId().longValue());
        assertEquals("Name", actualResponsableMetier.getName());
        assertEquals("ResponsableMetier(id=123, name=Name, email=jane.doe@example.org)",
                actualResponsableMetier.toString());
    }

    @Test
    void testEquals() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        assertNotEquals(null,responsableMetier);
    }

    @Test
    void testEquals10() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("jane.doe@example.org");

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");
        assertNotEquals(responsableMetier,responsableMetier1);
    }

    @Test
    void testEquals11() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail(null);
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail(null);
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");
        assertEquals(responsableMetier,responsableMetier1);
        int expectedHashCodeResult = responsableMetier.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetier1.hashCode());
    }

    @Test
    void testEquals12() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(null);
        responsableMetier.setName("Name");

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(null);
        responsableMetier1.setName("Name");
        assertEquals(responsableMetier,responsableMetier1);
        int expectedHashCodeResult = responsableMetier.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetier1.hashCode());
    }

    @Test
    void testEquals13() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName(null);

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName(null);
        assertEquals(responsableMetier,responsableMetier1);
        int expectedHashCodeResult = responsableMetier.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetier1.hashCode());
    }

    @Test
    void testEquals2() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        assertNotEquals("Different type to ResponsableMetier",responsableMetier);
    }

    @Test
    void testEquals3() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        assertEquals(responsableMetier,responsableMetier);
        int expectedHashCodeResult = responsableMetier.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetier.hashCode());
    }

    @Test
    void testEquals4() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");
        assertEquals(responsableMetier,responsableMetier1);
        int expectedHashCodeResult = responsableMetier.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetier1.hashCode());

        ////////////////
        ResponsableMetier responsableMetier2 = new ResponsableMetier();
        responsableMetier2.setEmail("Name");
        responsableMetier2.setId(123L);
        responsableMetier2.setName("Name");

        ResponsableMetier responsableMetier3 = new ResponsableMetier();
        responsableMetier3.setEmail("jane.doe@example.org");
        responsableMetier3.setId(123L);
        responsableMetier3.setName("Name");
        assertNotEquals(responsableMetier2,responsableMetier3);

        //////////
        ResponsableMetier responsableMetier4 = new ResponsableMetier();
        responsableMetier4.setEmail(null);
        responsableMetier4.setId(123L);
        responsableMetier4.setName("Name");

        ResponsableMetier responsableMetier5 = new ResponsableMetier();
        responsableMetier5.setEmail("jane.doe@example.org");
        responsableMetier5.setId(123L);
        responsableMetier5.setName("Name");
        assertNotEquals(responsableMetier4,responsableMetier5);

        ///////////////
        ResponsableMetier responsableMetier6 = new ResponsableMetier();
        responsableMetier6.setEmail("jane.doe@example.org");
        responsableMetier6.setId(0L);
        responsableMetier6.setName("Name");

        ResponsableMetier responsableMetier7 = new ResponsableMetier();
        responsableMetier7.setEmail("jane.doe@example.org");
        responsableMetier7.setId(123L);
        responsableMetier7.setName("Name");
        assertNotEquals(responsableMetier6,responsableMetier7);

        ///////////////

        ResponsableMetier responsableMetier8 = new ResponsableMetier();
        responsableMetier8.setEmail("jane.doe@example.org");
        responsableMetier8.setId(null);
        responsableMetier8.setName("Name");

        ResponsableMetier responsableMetier9 = new ResponsableMetier();
        responsableMetier9.setEmail("jane.doe@example.org");
        responsableMetier9.setId(123L);
        responsableMetier9.setName("Name");
        assertNotEquals(responsableMetier8,responsableMetier9);
    }





    @Test
    void testEquals9() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName(null);

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");
        assertNotEquals(responsableMetier,responsableMetier1);
    }
}

