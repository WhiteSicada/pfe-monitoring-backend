package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApiTest {
    @Test
    void testConstructor() {
        Api actualApi = new Api();
        List<Anomalie> anomalies = actualApi.getAnomalies();
        assertTrue(anomalies.isEmpty());
        assertEquals("Api(id=null, name=null, description=null, ip=null, port=0, token=null, status=false, db=false,"
                + " diskspace=false, ping=false, contexts=[], anomalies=[])", actualApi.toString());
        assertFalse(actualApi.isStatus());
        assertFalse(actualApi.isPing());
        assertFalse(actualApi.isDiskspace());
        assertFalse(actualApi.isDb());
        assertNull(actualApi.getToken());
        assertEquals(0, actualApi.getPort());
        assertNull(actualApi.getName());
        assertNull(actualApi.getIp());
        assertNull(actualApi.getId());
        assertNull(actualApi.getDescription());
        List<Context> contexts = actualApi.getContexts();
        assertEquals(anomalies, contexts);
        assertTrue(contexts.isEmpty());
    }

    @Test
    void testAddAnomalie() {
        Api api = new Api();

        Anomalie anomalie = new Anomalie();
        anomalie.setFixed(true);
        anomalie.setId(123L);
        anomalie.setEndpoint("https://config.us-east-2.amazonaws.com");
        anomalie.setDate("2020-03-01");
        anomalie.setError("An error occurred");
        api.addAnomalie(anomalie);
        assertEquals(1, api.getAnomalies().size());
    }

    @Test
    void testAddContext() {
        Api api = new Api();

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        api.addContext(context);
        assertEquals(1, api.getContexts().size());
    }

    @Test
    void testRemoveContext() {
        Api api = new Api();

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        api.removeContext(context);
        assertTrue(api.getContexts().isEmpty());
    }

    @Test
    void testRemoveContext2() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        Api api = new Api();
        api.addContext(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        api.removeContext(context1);
        assertTrue(api.getContexts().isEmpty());
    }

    @Test
    void testUpdateContext() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());

        Api api = new Api();
        api.addContext(context1);
        api.addContext(context);

        Context context2 = new Context();
        context2.setId(123L);
        context2.setName("Name");
        context2.setEndpoints(new ArrayList<Endpoint>());
        api.updateContext(1, context2);
        assertEquals(2, api.getContexts().size());
    }
}

