package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AnomalieTest {
    @Test
    void testConstructor() {
        Anomalie actualAnomalie = new Anomalie();
        assertNull(actualAnomalie.getDate());
        assertEquals("Anomalie(id=null, error=null, endpoint=null, date=null, fixed=false)", actualAnomalie.toString());
        assertFalse(actualAnomalie.isFixed());
        assertNull(actualAnomalie.getId());
        assertNull(actualAnomalie.getError());
        assertNull(actualAnomalie.getEndpoint());
    }

    @Test
    void testConstructor2() {
        Anomalie actualAnomalie = new Anomalie("An error occurred", "https://config.us-east-2.amazonaws.com", "2020-03-01");

        assertEquals("2020-03-01", actualAnomalie.getDate());
        assertEquals(
                "Anomalie(id=null, error=An error occurred, endpoint=https://config.us-east-2.amazonaws.com, date=2020-03-01,"
                        + " fixed=false)",
                actualAnomalie.toString());
        assertFalse(actualAnomalie.isFixed());
        assertNull(actualAnomalie.getId());
        assertEquals("An error occurred", actualAnomalie.getError());
        assertEquals("https://config.us-east-2.amazonaws.com", actualAnomalie.getEndpoint());
    }
}

