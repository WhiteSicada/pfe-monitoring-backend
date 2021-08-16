package com.bcp.monitoring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsableItTest {
    @Test
    void testCanEqual() {
        assertFalse((new ResponsableIt()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ResponsableIt responsableIt = new ResponsableIt();

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        assertTrue(responsableIt.canEqual(responsableIt1));
    }

    @Test
    void testConstructor() {
        ResponsableIt actualResponsableIt = new ResponsableIt();
        actualResponsableIt.setEmail("jane.doe@example.org");
        actualResponsableIt.setId(123L);
        actualResponsableIt.setName("Name");
        assertEquals("jane.doe@example.org", actualResponsableIt.getEmail());
        assertEquals(123L, actualResponsableIt.getId().longValue());
        assertEquals("Name", actualResponsableIt.getName());
        assertEquals("ResponsableIt(id=123, name=Name, email=jane.doe@example.org)", actualResponsableIt.toString());
    }

    @Test
    void testEquals() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        assertNotEquals(null, responsableIt);
    }

    @Test
    void testEquals10() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("jane.doe@example.org");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        assertNotEquals(responsableIt, responsableIt1);
    }

    @Test
    void testEquals11() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail(null);
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail(null);
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        assertEquals(responsableIt, responsableIt1);
        int expectedHashCodeResult = responsableIt.hashCode();
        assertEquals(expectedHashCodeResult, responsableIt1.hashCode());
    }

    @Test
    void testEquals12() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(null);
        responsableIt.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(null);
        responsableIt1.setName("Name");
        assertEquals(responsableIt, responsableIt1);
        int expectedHashCodeResult = responsableIt.hashCode();
        assertEquals(expectedHashCodeResult, responsableIt1.hashCode());
    }

    @Test
    void testEquals13() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName(null);

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName(null);
        assertEquals(responsableIt, responsableIt1);
        int expectedHashCodeResult = responsableIt.hashCode();
        assertEquals(expectedHashCodeResult, responsableIt1.hashCode());
    }

    @Test
    void testEquals2() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        assertNotEquals("Different type to ResponsableIt", responsableIt);
    }

    @Test
    void testEquals3() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        assertEquals(responsableIt, responsableIt);
        int expectedHashCodeResult = responsableIt.hashCode();
        assertEquals(expectedHashCodeResult, responsableIt.hashCode());
    }

    @Test
    void testEquals4() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        assertEquals(responsableIt, responsableIt1);
        int expectedHashCodeResult = responsableIt.hashCode();
        assertEquals(expectedHashCodeResult, responsableIt1.hashCode());
    }

    @Test
    void testEquals5() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("Name");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        
        assertEquals(responsableIt, responsableIt);

        ///////
        ResponsableIt responsableIt2 = new ResponsableIt();
        responsableIt2.setEmail(null);
        responsableIt2.setId(123L);
        responsableIt2.setName("Name");

        ResponsableIt responsableIt3 = new ResponsableIt();
        responsableIt3.setEmail("jane.doe@example.org");
        responsableIt3.setId(123L);
        responsableIt3.setName("Name");

        assertNotEquals(responsableIt2, responsableIt3);

        //////
        ResponsableIt responsableIt4 = new ResponsableIt();
        responsableIt4.setEmail("jane.doe@example.org");
        responsableIt4.setId(0L);
        responsableIt4.setName("Name");

        ResponsableIt responsableIt5 = new ResponsableIt();
        responsableIt5.setEmail("jane.doe@example.org");
        responsableIt5.setId(123L);
        responsableIt5.setName("Name");

        assertNotEquals(responsableIt4, responsableIt5);

        //////////
        ResponsableIt responsableIt6 = new ResponsableIt();
        responsableIt6.setEmail("jane.doe@example.org");
        responsableIt6.setId(null);
        responsableIt6.setName("Name");

        ResponsableIt responsableIt7 = new ResponsableIt();
        responsableIt7.setEmail("jane.doe@example.org");
        responsableIt7.setId(123L);
        responsableIt7.setName("Name");

        assertNotEquals(responsableIt6, responsableIt7);
    }




    @Test
    void testEquals9() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName(null);

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        
        assertEquals(responsableIt, responsableIt);
    }
}

