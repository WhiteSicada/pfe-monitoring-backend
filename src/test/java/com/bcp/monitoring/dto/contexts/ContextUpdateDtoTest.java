package com.bcp.monitoring.dto.contexts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextUpdateDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new ContextUpdateDto()).canEqual("Other"));
        assertFalse((new ContextUpdateDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertTrue(contextUpdateDto.canEqual(contextUpdateDto1));
    }

    @Test
    void testCanEqual3() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertTrue(contextUpdateDto.canEqual(contextUpdateDto1));
    }

    @Test
    void testConstructor() {
        ContextUpdateDto actualContextUpdateDto = new ContextUpdateDto();
        actualContextUpdateDto.setId(123L);
        actualContextUpdateDto.setName("Name");
        assertEquals(123L, actualContextUpdateDto.getId().longValue());
        assertEquals("Name", actualContextUpdateDto.getName());
        assertEquals("ContextUpdateDto(id=123, name=Name)", actualContextUpdateDto.toString());
    }

    @Test
    void testConstructor2() {
        ContextUpdateDto actualContextUpdateDto = new ContextUpdateDto();
        actualContextUpdateDto.setId(123L);
        actualContextUpdateDto.setName("Name");
        assertEquals(123L, actualContextUpdateDto.getId().longValue());
        assertEquals("Name", actualContextUpdateDto.getName());
        assertEquals("ContextUpdateDto(id=123, name=Name)", actualContextUpdateDto.toString());
    }

    @Test
    void testEquals() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");
        assertNotEquals(null,contextUpdateDto);

        ////
        ContextUpdateDto contextUpdateDto2 = new ContextUpdateDto();
        contextUpdateDto2.setId(123L);
        contextUpdateDto2.setName("Name");
        assertNotEquals(null,contextUpdateDto2);

        /////
        ContextUpdateDto contextUpdateDto3 = new ContextUpdateDto();
        contextUpdateDto3.setId(123L);
        contextUpdateDto3.setName("Name");
        assertNotEquals("Different type to ContextUpdateDto",contextUpdateDto3);

        //
    }

    @Test
    void testEquals10() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName(null);

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName(null);
        assertEquals(contextUpdateDto,contextUpdateDto1);
        int expectedHashCodeResult = contextUpdateDto.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto1.hashCode());


        /////
        ContextUpdateDto contextUpdateDto2 = new ContextUpdateDto();
        contextUpdateDto2.setId(123L);
        contextUpdateDto2.setName("Name");

        ContextUpdateDto contextUpdateDto3 = new ContextUpdateDto();
        contextUpdateDto3.setId(123L);
        contextUpdateDto3.setName("Name");
        assertEquals(contextUpdateDto2,contextUpdateDto3);
        int expectedHashCodeResult2 = contextUpdateDto2.hashCode();
        assertEquals(expectedHashCodeResult2, contextUpdateDto3.hashCode());
    }

    @Test
    void testEquals13() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");
        assertEquals(contextUpdateDto,contextUpdateDto);
        assertEquals(contextUpdateDto,contextUpdateDto);
        int expectedHashCodeResult = contextUpdateDto.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto.hashCode());
    }



    @Test
    void testEquals15() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(0L);
        contextUpdateDto.setName("Name");

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertNotEquals(contextUpdateDto,contextUpdateDto1);

        /////
        ContextUpdateDto contextUpdateDto2 = new ContextUpdateDto();
        contextUpdateDto2.setId(null);
        contextUpdateDto2.setName("Name");

        ContextUpdateDto contextUpdateDto3 = new ContextUpdateDto();
        contextUpdateDto3.setId(123L);
        contextUpdateDto3.setName("Name");
        assertNotEquals(contextUpdateDto2,contextUpdateDto3);

        /////
        ContextUpdateDto contextUpdateDto4 = new ContextUpdateDto();
        contextUpdateDto4.setId(123L);
        contextUpdateDto4.setName(null);

        ContextUpdateDto contextUpdateDto5 = new ContextUpdateDto();
        contextUpdateDto5.setId(123L);
        contextUpdateDto5.setName("Name");
        assertNotEquals(contextUpdateDto4,contextUpdateDto5);

        ///////
        ContextUpdateDto contextUpdateDto6 = new ContextUpdateDto();
        contextUpdateDto6.setId(123L);
        contextUpdateDto6.setName("com.bcp.monitoring.dto.contexts.ContextUpdateDto");

        ContextUpdateDto contextUpdateDto7 = new ContextUpdateDto();
        contextUpdateDto7.setId(123L);
        contextUpdateDto7.setName("Name");
        assertNotEquals(contextUpdateDto6,contextUpdateDto7);

        ///////
        ContextUpdateDto contextUpdateDto8 = new ContextUpdateDto();
        contextUpdateDto8.setId(null);
        contextUpdateDto8.setName("Name");

        ContextUpdateDto contextUpdateDto9 = new ContextUpdateDto();
        contextUpdateDto9.setId(null);
        contextUpdateDto9.setName("Name");
        assertEquals(contextUpdateDto8,contextUpdateDto9);
        int expectedHashCodeResult = contextUpdateDto8.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto9.hashCode());
    }



    @Test
    void testEquals2() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");
        assertNotEquals("Different type to ContextUpdateDto",contextUpdateDto);
    }

    @Test
    void testEquals20() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName(null);

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName(null);
        assertEquals(contextUpdateDto,contextUpdateDto1);
        int expectedHashCodeResult = contextUpdateDto.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto1.hashCode());
    }

    @Test
    void testEquals3() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");
        assertEquals(contextUpdateDto,contextUpdateDto);
        int expectedHashCodeResult = contextUpdateDto.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto.hashCode());
    }

    @Test
    void testEquals4() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertEquals(contextUpdateDto,contextUpdateDto1);
        int expectedHashCodeResult = contextUpdateDto.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto1.hashCode());
    }

    @Test
    void testEquals5() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(0L);
        contextUpdateDto.setName("Name");

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertNotEquals(contextUpdateDto,contextUpdateDto1);


        ////
        ContextUpdateDto contextUpdateDto9 = new ContextUpdateDto();
        contextUpdateDto9.setId(123L);
        contextUpdateDto9.setName(null);

        ContextUpdateDto contextUpdateDto119 = new ContextUpdateDto();
        contextUpdateDto119.setId(123L);
        contextUpdateDto119.setName("Name");
        assertNotEquals(contextUpdateDto9,contextUpdateDto119);
    }

    @Test
    void testEquals6() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(null);
        contextUpdateDto.setName("Name");

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertNotEquals(contextUpdateDto,contextUpdateDto1);
    }



    @Test
    void testEquals8() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("com.bcp.monitoring.dto.contexts.ContextUpdateDto");

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(123L);
        contextUpdateDto1.setName("Name");
        assertNotEquals(contextUpdateDto,contextUpdateDto1);
    }

    @Test
    void testEquals9() {
        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(null);
        contextUpdateDto.setName("Name");

        ContextUpdateDto contextUpdateDto1 = new ContextUpdateDto();
        contextUpdateDto1.setId(null);
        contextUpdateDto1.setName("Name");
        assertEquals(contextUpdateDto,contextUpdateDto1);
        int expectedHashCodeResult = contextUpdateDto.hashCode();
        assertEquals(expectedHashCodeResult, contextUpdateDto1.hashCode());
    }
}

