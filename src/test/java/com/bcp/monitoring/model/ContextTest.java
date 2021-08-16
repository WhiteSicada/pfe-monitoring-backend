package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ContextTest {
    @Test
    void testConstructor() {
        Context actualContext = new Context();
        assertNull(actualContext.getEndpoints());
        assertEquals("Context(id=null, name=null, endpoints=null)", actualContext.toString());
        assertNull(actualContext.getName());
        assertNull(actualContext.getId());
    }

    @Test
    void testConstructor2() {
        ArrayList<Endpoint> endpointList = new ArrayList<Endpoint>();
        Context actualContext = new Context("Name", endpointList);

        List<Endpoint> endpoints = actualContext.getEndpoints();
        assertSame(endpointList, endpoints);
        assertTrue(endpoints.isEmpty());
        assertEquals("Context(id=null, name=Name, endpoints=[])", actualContext.toString());
        assertEquals("Name", actualContext.getName());
        assertNull(actualContext.getId());
        assertSame(endpoints, endpointList);
    }

    @Test
    void testAddEndpoint() {
        Context context = new Context("Name", new ArrayList<Endpoint>());

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        context.addEndpoint(endpoint);
        assertEquals(1, context.getEndpoints().size());
    }

    @Test
    void testRemoveEndpoint() {
        Context context = new Context("Name", new ArrayList<Endpoint>());

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        context.removeEndpoint(endpoint);
        assertTrue(context.getEndpoints().isEmpty());
    }
}

