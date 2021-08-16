package com.bcp.monitoring.dto.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ListEndpointDtoTest {
    @Test
    void testConstructor() {
        assertEquals("ListEndpointDto{endpoints=null}", (new ListEndpointDto()).toString());
    }
}

