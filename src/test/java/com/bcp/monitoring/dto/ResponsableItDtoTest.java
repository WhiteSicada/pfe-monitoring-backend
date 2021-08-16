package com.bcp.monitoring.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsableItDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new ResponsableItDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ResponsableItDto responsableItDto = new ResponsableItDto();

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertTrue(responsableItDto.canEqual(responsableItDto1));
    }

    @Test
    void testConstructor() {
        ResponsableItDto actualResponsableItDto = new ResponsableItDto();
        actualResponsableItDto.setEmail("jane.doe@example.org");
        actualResponsableItDto.setId(123L);
        actualResponsableItDto.setName("Name");
        assertEquals("jane.doe@example.org", actualResponsableItDto.getEmail());
        assertEquals(123L, actualResponsableItDto.getId().longValue());
        assertEquals("Name", actualResponsableItDto.getName());
        assertEquals("ResponsableItDto(id=123, name=Name, email=jane.doe@example.org)", actualResponsableItDto.toString());
    }

    @Test
    void testEquals() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        assertNotEquals(null,responsableItDto);
    }

    @Test
    void testEquals10() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("jane.doe@example.org");

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertNotEquals(responsableItDto,responsableItDto1);

        ////
        ResponsableItDto responsableItDto2 = new ResponsableItDto();
        responsableItDto2.setEmail("Name");
        responsableItDto2.setId(123L);
        responsableItDto2.setName("Name");

        ResponsableItDto responsableItDto3 = new ResponsableItDto();
        responsableItDto3.setEmail("jane.doe@example.org");
        responsableItDto3.setId(123L);
        responsableItDto3.setName("Name");
        assertNotEquals(responsableItDto2,responsableItDto3);

        ///
        ResponsableItDto responsableItDt4 = new ResponsableItDto();
        responsableItDt4.setEmail(null);
        responsableItDt4.setId(123L);
        responsableItDt4.setName("Name");

        ResponsableItDto responsableItDto5 = new ResponsableItDto();
        responsableItDto5.setEmail("jane.doe@example.org");
        responsableItDto5.setId(123L);
        responsableItDto5.setName("Name");
        assertNotEquals(responsableItDt4,responsableItDto5);
    }

    @Test
    void testEquals11() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail(null);
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail(null);
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertEquals(responsableItDto,responsableItDto1);
        int expectedHashCodeResult = responsableItDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableItDto1.hashCode());
    }

    @Test
    void testEquals12() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(null);
        responsableItDto.setName("Name");

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(null);
        responsableItDto1.setName("Name");
        assertEquals(responsableItDto,responsableItDto1);
        int expectedHashCodeResult = responsableItDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableItDto1.hashCode());
    }

    @Test
    void testEquals13() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName(null);

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName(null);
        assertEquals(responsableItDto,responsableItDto1);
        int expectedHashCodeResult = responsableItDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableItDto1.hashCode());
    }

    @Test
    void testEquals2() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        assertNotEquals("Different type to ResponsableItDto",responsableItDto);
    }

    @Test
    void testEquals3() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        assertEquals(responsableItDto,responsableItDto);
        int expectedHashCodeResult = responsableItDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableItDto.hashCode());
    }

    @Test
    void testEquals4() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertEquals(responsableItDto,responsableItDto1);
        int expectedHashCodeResult = responsableItDto.hashCode();
        assertEquals(expectedHashCodeResult, responsableItDto1.hashCode());
    }



    @Test
    void testEquals7() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(0L);
        responsableItDto.setName("Name");

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertNotEquals(responsableItDto,responsableItDto1);
    }

    @Test
    void testEquals8() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(null);
        responsableItDto.setName("Name");

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertNotEquals(responsableItDto,responsableItDto1);
    }

    @Test
    void testEquals9() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName(null);

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertNotEquals(responsableItDto,responsableItDto1);
    }
}

