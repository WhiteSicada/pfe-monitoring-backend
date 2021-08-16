package com.bcp.monitoring.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipeDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new EquipeDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        EquipeDto equipeDto = new EquipeDto();

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertTrue(equipeDto.canEqual(equipeDto1));
    }

    @Test
    void testConstructor() {
        EquipeDto actualEquipeDto = new EquipeDto();
        actualEquipeDto.setId(123L);
        actualEquipeDto.setName("Name");
        assertEquals(123L, actualEquipeDto.getId().longValue());
        assertEquals("Name", actualEquipeDto.getName());
        assertEquals("EquipeDto(id=123, name=Name)", actualEquipeDto.toString());
    }

    @Test
    void testEquals() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");
        assertNotEquals(null,equipeDto);
    }

    @Test
    void testEquals10() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName(null);

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName(null);
        assertEquals(equipeDto,equipeDto1);
        int expectedHashCodeResult = equipeDto.hashCode();
        assertEquals(expectedHashCodeResult, equipeDto1.hashCode());
    }

    @Test
    void testEquals2() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");
        assertNotEquals("Different type to EquipeDto",equipeDto);
    }

    @Test
    void testEquals3() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");
        assertEquals(equipeDto,equipeDto);
        int expectedHashCodeResult = equipeDto.hashCode();
        assertEquals(expectedHashCodeResult, equipeDto.hashCode());
    }

    @Test
    void testEquals4() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertEquals(equipeDto,equipeDto1);
        int expectedHashCodeResult = equipeDto.hashCode();
        assertEquals(expectedHashCodeResult, equipeDto1.hashCode());
        /////
        EquipeDto equipeDto2 = new EquipeDto();
        equipeDto2.setId(0L);
        equipeDto2.setName("Name");

        EquipeDto equipeDto3 = new EquipeDto();
        equipeDto3.setId(123L);
        equipeDto3.setName("Name");
        assertNotEquals(equipeDto2,equipeDto3);
    }



    @Test
    void testEquals6() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(null);
        equipeDto.setName("Name");

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertNotEquals(equipeDto,equipeDto1);
    }

    @Test
    void testEquals7() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName(null);

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertNotEquals(equipeDto,equipeDto1);
    }

    @Test
    void testEquals8() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("com.bcp.monitoring.dto.EquipeDto");

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertNotEquals(equipeDto,equipeDto1);
    }

    @Test
    void testEquals9() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(null);
        equipeDto.setName("Name");

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(null);
        equipeDto1.setName("Name");
        assertEquals(equipeDto,equipeDto1);
        assertEquals(equipeDto.hashCode(), equipeDto1.hashCode());
    }
}

