package com.bcp.monitoring.dto.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListApisDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new ListApisDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ListApisDto listApisDto = new ListApisDto();

        ListApisDto listApisDto1 = new ListApisDto();
        listApisDto1.setApis(new String[]{"Apis"});
        assertTrue(listApisDto.canEqual(listApisDto1));
    }

    @Test
    void testConstructor() {
        ListApisDto actualListApisDto = new ListApisDto();
        actualListApisDto.setApis(new String[]{"Apis"});
        assertEquals("ListApisDto(apis=[Apis])", actualListApisDto.toString());
    }

    @Test
    void testEquals() {
        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertNotEquals(null,listApisDto);
    }

    @Test
    void testEquals2() {
        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertNotEquals("Different type to ListApisDto",listApisDto);
    }

    @Test
    void testEquals3() {
        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertEquals(listApisDto,listApisDto);
        int expectedHashCodeResult = listApisDto.hashCode();
        assertEquals(expectedHashCodeResult, listApisDto.hashCode());
    }

    @Test
    void testEquals4() {
        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});

        ListApisDto listApisDto1 = new ListApisDto();
        listApisDto1.setApis(new String[]{"Apis"});
        assertEquals(listApisDto,listApisDto1);
        int expectedHashCodeResult = listApisDto.hashCode();
        assertEquals(expectedHashCodeResult, listApisDto1.hashCode());
    }

    @Test
    void testEquals5() {
        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"com.bcp.monitoring.dto.api.ListApisDto"});

        ListApisDto listApisDto1 = new ListApisDto();
        listApisDto1.setApis(new String[]{"Apis"});
        assertNotEquals(listApisDto,listApisDto1);
    }
}

