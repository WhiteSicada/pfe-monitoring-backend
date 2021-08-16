package com.bcp.monitoring.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsableMetierDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new ResponsableMetierDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertTrue(responsableMetierDto.canEqual(responsableMetierDto1));
    }

    @Test
    void testConstructor() {
        ResponsableMetierDto actualResponsableMetierDto = new ResponsableMetierDto();
        actualResponsableMetierDto.setEmail("jane.doe@example.org");
        actualResponsableMetierDto.setId(123L);
        actualResponsableMetierDto.setName("Name");
        assertEquals("jane.doe@example.org", actualResponsableMetierDto.getEmail());
        assertEquals(123L, actualResponsableMetierDto.getId().longValue());
        assertEquals("Name", actualResponsableMetierDto.getName());
        assertEquals("ResponsableMetierDto(id=123, name=Name, email=jane.doe@example.org)",
                actualResponsableMetierDto.toString());
    }

    @Test
    void testEquals() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        assertNotEquals(null,responsableMetierDto);
    }

    @Test
    void testEquals10() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("jane.doe@example.org");

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertNotEquals(responsableMetierDto,responsableMetierDto1);

        /////
        ResponsableMetierDto responsableMetierDto2 = new ResponsableMetierDto();
        responsableMetierDto2.setEmail("Name");
        responsableMetierDto2.setId(123L);
        responsableMetierDto2.setName("Name");

        ResponsableMetierDto responsableMetierDto13 = new ResponsableMetierDto();
        responsableMetierDto13.setEmail("jane.doe@example.org");
        responsableMetierDto13.setId(123L);
        responsableMetierDto13.setName("Name");
        assertNotEquals(responsableMetierDto2,responsableMetierDto13);

        /////
        ResponsableMetierDto responsableMetierDto30 = new ResponsableMetierDto();
        responsableMetierDto30.setEmail(null);
        responsableMetierDto30.setId(123L);
        responsableMetierDto30.setName("Name");

        ResponsableMetierDto responsableMetierDto131 = new ResponsableMetierDto();
        responsableMetierDto131.setEmail("jane.doe@example.org");
        responsableMetierDto131.setId(123L);
        responsableMetierDto131.setName("Name");
        assertNotEquals(responsableMetierDto30,responsableMetierDto131);

        //
    }

    @Test
    void testEquals11() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail(null);
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail(null);
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertEquals(responsableMetierDto,responsableMetierDto1);
        int expectedHashCodeResult = responsableMetierDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetierDto1.hashCode());
    }

    @Test
    void testEquals12() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(null);
        responsableMetierDto.setName("Name");

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(null);
        responsableMetierDto1.setName("Name");
        assertEquals(responsableMetierDto,responsableMetierDto1);
        int expectedHashCodeResult = responsableMetierDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetierDto1.hashCode());
    }

    @Test
    void testEquals13() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName(null);

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName(null);
        assertEquals(responsableMetierDto,responsableMetierDto1);
        int expectedHashCodeResult = responsableMetierDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetierDto1.hashCode());
    }

    @Test
    void testEquals2() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        assertNotEquals("Different type to ResponsableMetierDto",responsableMetierDto);
    }

    @Test
    void testEquals3() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        assertEquals(responsableMetierDto,responsableMetierDto);
        int expectedHashCodeResult = responsableMetierDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetierDto.hashCode());
    }

    @Test
    void testEquals4() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertEquals(responsableMetierDto,responsableMetierDto1);
        int expectedHashCodeResult = responsableMetierDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableMetierDto1.hashCode());
    }


    @Test
    void testEquals7() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(0L);
        responsableMetierDto.setName("Name");

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertNotEquals(responsableMetierDto,responsableMetierDto1);
    }

    @Test
    void testEquals8() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(null);
        responsableMetierDto.setName("Name");

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertNotEquals(responsableMetierDto,responsableMetierDto1);
    }

    @Test
    void testEquals9() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName(null);

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertNotEquals(responsableMetierDto,responsableMetierDto1);
    }
}

