package com.bcp.monitoring.dto.endpoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndpointDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new EndpointDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        EndpointDto endpointDto = new EndpointDto();

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertTrue(endpointDto.canEqual(endpointDto1));
    }

    @Test
    void testConstructor() {
        EndpointDto actualEndpointDto = new EndpointDto();
        actualEndpointDto.setData("Data");
        actualEndpointDto.setId(123L);
        actualEndpointDto.setMethod("Method");
        actualEndpointDto.setName("Name");
        actualEndpointDto.setUrl("https://example.org/example");
        assertEquals("Data", actualEndpointDto.getData());
        assertEquals(123L, actualEndpointDto.getId().longValue());
        assertEquals("Method", actualEndpointDto.getMethod());
        assertEquals("Name", actualEndpointDto.getName());
        assertEquals("https://example.org/example", actualEndpointDto.getUrl());
        assertEquals("EndpointDto(id=123, name=Name, url=https://example.org/example, method=Method, data=Data)",
                actualEndpointDto.toString());
    }

    @Test
    void testEquals() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");
        assertNotEquals(null,endpointDto);
    }

    @Test
    void testEquals10() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("https://example.org/example");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals11() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Name");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals12() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData(null);
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals13() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Name");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals14() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod(null);

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals15() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(null);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(null);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertEquals(endpointDto,endpointDto1);
        int expectedHashCodeResult = endpointDto.hashCode();
        assertEquals(expectedHashCodeResult, endpointDto1.hashCode());
    }

    @Test
    void testEquals16() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl(null);
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl(null);
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertEquals(endpointDto,endpointDto1);
        int expectedHashCodeResult = endpointDto.hashCode();
        assertEquals(expectedHashCodeResult, endpointDto1.hashCode());
    }

    @Test
    void testEquals17() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName(null);
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName(null);
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertEquals(endpointDto,endpointDto1);
        int expectedHashCodeResult = endpointDto.hashCode();
        assertEquals(expectedHashCodeResult, endpointDto1.hashCode());
    }

    @Test
    void testEquals18() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData(null);
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData(null);
        endpointDto1.setMethod("Method");
        assertEquals(endpointDto,endpointDto1);
        int expectedHashCodeResult = endpointDto.hashCode();
        assertEquals(expectedHashCodeResult, endpointDto1.hashCode());
    }

    @Test
    void testEquals2() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");
        assertNotEquals("Different type to EndpointDto",endpointDto);
    }

    @Test
    void testEquals3() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");
        assertEquals(endpointDto,endpointDto);
        int expectedHashCodeResult = endpointDto.hashCode();
        assertEquals(expectedHashCodeResult, endpointDto.hashCode());
    }

    @Test
    void testEquals4() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertEquals(endpointDto,endpointDto1);
        int expectedHashCodeResult = endpointDto.hashCode();
        assertEquals(expectedHashCodeResult, endpointDto1.hashCode());
    }

    @Test
    void testEquals5() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(0L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals6() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(null);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals7() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("Name");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals8() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl(null);
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }

    @Test
    void testEquals9() {
        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName(null);
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");

        EndpointDto endpointDto1 = new EndpointDto();
        endpointDto1.setId(123L);
        endpointDto1.setUrl("https://example.org/example");
        endpointDto1.setName("Name");
        endpointDto1.setData("Data");
        endpointDto1.setMethod("Method");
        assertNotEquals(endpointDto,endpointDto1);
    }
}

