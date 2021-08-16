package com.bcp.monitoring.dto.anomalie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnomalieDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new AnomalieDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        AnomalieDto anomalieDto = new AnomalieDto();

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertTrue(anomalieDto.canEqual(anomalieDto1));
    }

    @Test
    void testConstructor() {
        AnomalieDto actualAnomalieDto = new AnomalieDto();
        actualAnomalieDto.setDate("2020-03-01");
        actualAnomalieDto.setError("An error occurred");
        actualAnomalieDto.setFixed(true);
        actualAnomalieDto.setId(123L);
        assertEquals("2020-03-01", actualAnomalieDto.getDate());
        assertEquals("An error occurred", actualAnomalieDto.getError());
        assertEquals(123L, actualAnomalieDto.getId().longValue());
        assertTrue(actualAnomalieDto.isFixed());
        assertEquals("AnomalieDto(id=123, error=An error occurred, date=2020-03-01, fixed=true)",
                actualAnomalieDto.toString());
    }

    @Test
    void testEquals() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");
        assertNotEquals(null,anomalieDto);
    }

    @Test
    void testEquals10() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError(null);

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }

    @Test
    void testEquals11() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("2020-03-01");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }

    @Test
    void testEquals12() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(null);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(null);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertEquals(anomalieDto,anomalieDto1);
        int expectedHashCodeResult = anomalieDto.hashCode();
        assertEquals(expectedHashCodeResult, anomalieDto1.hashCode());
    }

    @Test
    void testEquals13() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate(null);
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate(null);
        anomalieDto1.setError("An error occurred");
        assertEquals(anomalieDto,anomalieDto1);
        int expectedHashCodeResult = anomalieDto.hashCode();
        assertEquals(expectedHashCodeResult, anomalieDto1.hashCode());
    }

    @Test
    void testEquals14() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError(null);

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError(null);
        assertEquals(anomalieDto,anomalieDto1);
        int expectedHashCodeResult = anomalieDto.hashCode();
        assertEquals(expectedHashCodeResult, anomalieDto1.hashCode());
    }

    @Test
    void testEquals2() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");
        assertNotEquals("Different type to AnomalieDto",anomalieDto);
    }

    @Test
    void testEquals3() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");
        assertEquals(anomalieDto,anomalieDto);
        int expectedHashCodeResult = anomalieDto.hashCode();
        assertEquals(expectedHashCodeResult, anomalieDto.hashCode());
    }

    @Test
    void testEquals4() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertEquals(anomalieDto,anomalieDto1);
        int expectedHashCodeResult = anomalieDto.hashCode();
        assertEquals(expectedHashCodeResult, anomalieDto1.hashCode());
    }

    @Test
    void testEquals5() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(false);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }

    @Test
    void testEquals6() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(0L);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }

    @Test
    void testEquals7() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(null);
        anomalieDto.setDate("2020-03-01");
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }

    @Test
    void testEquals8() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate("2020/03/01");
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }

    @Test
    void testEquals9() {
        AnomalieDto anomalieDto = new AnomalieDto();
        anomalieDto.setFixed(true);
        anomalieDto.setId(123L);
        anomalieDto.setDate(null);
        anomalieDto.setError("An error occurred");

        AnomalieDto anomalieDto1 = new AnomalieDto();
        anomalieDto1.setFixed(true);
        anomalieDto1.setId(123L);
        anomalieDto1.setDate("2020-03-01");
        anomalieDto1.setError("An error occurred");
        assertNotEquals(anomalieDto,anomalieDto1);
    }
}

