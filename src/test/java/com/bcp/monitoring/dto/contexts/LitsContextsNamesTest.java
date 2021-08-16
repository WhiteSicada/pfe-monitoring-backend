package com.bcp.monitoring.dto.contexts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LitsContextsNamesTest {
    @Test
    void testCanEqual() {
        assertFalse((new LitsContextsNames()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        LitsContextsNames litsContextsNames = new LitsContextsNames();

        LitsContextsNames litsContextsNames1 = new LitsContextsNames();
        litsContextsNames1.setContexts(new String[]{"Contexts"});
        assertTrue(litsContextsNames.canEqual(litsContextsNames1));
    }

    @Test
    void testConstructor() {
        LitsContextsNames actualLitsContextsNames = new LitsContextsNames();
        actualLitsContextsNames.setContexts(new String[]{"Contexts"});
        assertEquals("LitsContextsNames(contexts=[Contexts])", actualLitsContextsNames.toString());
    }

    @Test
    void testEquals() {
        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});
        assertNotEquals(null,litsContextsNames);
    }

    @Test
    void testEquals2() {
        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});
        assertNotEquals("Different type to LitsContextsNames",litsContextsNames);
    }

    @Test
    void testEquals3() {
        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});
        assertEquals(litsContextsNames,litsContextsNames);
        int expectedHashCodeResult = litsContextsNames.hashCode();
        assertEquals(expectedHashCodeResult, litsContextsNames.hashCode());
    }

    @Test
    void testEquals4() {
        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});

        LitsContextsNames litsContextsNames1 = new LitsContextsNames();
        litsContextsNames1.setContexts(new String[]{"Contexts"});
        assertEquals(litsContextsNames,litsContextsNames1);
        int expectedHashCodeResult = litsContextsNames.hashCode();
        assertEquals(expectedHashCodeResult, litsContextsNames1.hashCode());
    }

    @Test
    void testEquals5() {
        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"com.bcp.monitoring.dto.contexts.LitsContextsNames"});

        LitsContextsNames litsContextsNames1 = new LitsContextsNames();
        litsContextsNames1.setContexts(new String[]{"Contexts"});
        assertNotEquals(litsContextsNames,litsContextsNames1);
    }
}

