package com.bcp.monitoring.dto.contexts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListContextsObjectsTest {
    @Test
    void testCanEqual() {
        assertFalse((new ListContextsObjects()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ListContextsObjects listContextsObjects = new ListContextsObjects();

        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects1 = new ListContextsObjects();
        listContextsObjects1.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertTrue(listContextsObjects.canEqual(listContextsObjects1));
    }

    @Test
    void testConstructor() {
        ListContextsObjects actualListContextsObjects = new ListContextsObjects();
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");
        actualListContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertEquals("ListContextsObjects(contexts=[ContextUpdateDto(id=123, name=Name)])",
                actualListContextsObjects.toString());
    }

    @Test
    void testEquals() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertNotEquals(null,listContextsObjects);
    }

    @Test
    void testEquals2() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertNotEquals("Different type to ListContextsObjects",listContextsObjects);
    }

    @Test
    void testEquals3() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertEquals(listContextsObjects,listContextsObjects);
        int expectedHashCodeResult = listContextsObjects.hashCode();
        assertEquals(expectedHashCodeResult, listContextsObjects.hashCode());
    }

    @Test
    void testEquals4() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");

        ListContextsObjects listContextsObjects1 = new ListContextsObjects();
        listContextsObjects1.setContexts(new ContextUpdateDto[]{contextUpdateDto1});
        assertEquals(listContextsObjects,listContextsObjects1);
        int expectedHashCodeResult = listContextsObjects.hashCode();
        assertEquals(expectedHashCodeResult, listContextsObjects1.hashCode());
    }
}

