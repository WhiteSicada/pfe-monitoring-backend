package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EndpointTest {
    @Test
    void testConstructor() {
        assertEquals("Endpoint{id=null, name='null', url='null', method='null', data='null'}", (new Endpoint()).toString());
    }
}

