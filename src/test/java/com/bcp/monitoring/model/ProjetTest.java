package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ProjetTest {
    @Test
    void testAddAPI() {
        Api api = new Api();
        api.setPort(8080);
        api.setIp("127.0.0.1");
        api.setStatus(true);
        api.setDb(true);
        api.setPing(true);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(true);
        api.setToken("ABC123");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());

        Projet projet = new Projet();
        projet.setApis(new HashSet<Api>());
        projet.addAPI(api);

        Api api1 = new Api();
        api1.setPort(8080);
        api1.setIp("127.0.0.1");
        api1.setStatus(true);
        api1.setDb(true);
        api1.setPing(true);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(true);
        api1.setToken("ABC123");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        projet.addAPI(api1);
        assertEquals(1, projet.getApis().size());
    }

    @Test
    void testRemoveAPI() {
        Api api = new Api();
        api.setPort(8080);
        api.setIp("127.0.0.1");
        api.setStatus(true);
        api.setDb(true);
        api.setPing(true);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(true);
        api.setToken("ABC123");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());

        Projet projet = new Projet();
        projet.setApis(new HashSet<Api>());
        projet.addAPI(api);

        Api api1 = new Api();
        api1.setPort(8080);
        api1.setIp("127.0.0.1");
        api1.setStatus(true);
        api1.setDb(true);
        api1.setPing(true);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(true);
        api1.setToken("ABC123");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        projet.removeAPI(api1);
        assertTrue(projet.getApis().isEmpty());
    }
}

