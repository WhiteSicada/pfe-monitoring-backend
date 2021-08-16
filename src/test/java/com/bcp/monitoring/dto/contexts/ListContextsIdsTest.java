package com.bcp.monitoring.dto.contexts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListContextsIdsTest {
    @Test
    void testCanEqual() {
        assertFalse((new ListContextsIds()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ListContextsIds listContextsIds = new ListContextsIds();

        ListContextsIds listContextsIds1 = new ListContextsIds();
        listContextsIds1.setContexts(new Long[]{0L});
        assertTrue(listContextsIds.canEqual(listContextsIds1));
    }

    @Test
    void testConstructor() {
        ListContextsIds actualListContextsIds = new ListContextsIds();
        actualListContextsIds.setContexts(new Long[]{1L});
        assertEquals("ListContextsIds(contexts=[1])", actualListContextsIds.toString());
    }

    @Test
    void testEquals() {
        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertNotEquals(null,listContextsIds);
    }

    @Test
    void testEquals2() {
        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertNotEquals("Different type to ListContextsIds",listContextsIds);
    }

    @Test
    void testEquals3() {
        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertEquals(listContextsIds,listContextsIds);
        int expectedHashCodeResult = listContextsIds.hashCode();
        assertEquals(expectedHashCodeResult, listContextsIds.hashCode());
    }

    @Test
    void testEquals4() {
        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});

        ListContextsIds listContextsIds1 = new ListContextsIds();
        listContextsIds1.setContexts(new Long[]{1L});
        assertEquals(listContextsIds,listContextsIds1);
        int expectedHashCodeResult = listContextsIds.hashCode();
        assertEquals(expectedHashCodeResult, listContextsIds1.hashCode());
    }

    @Test
    void testEquals5() {
        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{0L});

        ListContextsIds listContextsIds1 = new ListContextsIds();
        listContextsIds1.setContexts(new Long[]{1L});
        assertNotEquals(listContextsIds,listContextsIds1);
    }
}

