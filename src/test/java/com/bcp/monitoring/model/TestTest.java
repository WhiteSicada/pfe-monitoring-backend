package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

class TestTest {
    @org.junit.jupiter.api.Test
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

        Test test = new Test();
        test.setListAPIs(new ArrayList<Api>());
        test.addAPI(api);

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
        test.addAPI(api1);
        assertEquals(2, test.getListAPIs().size());
    }

    @org.junit.jupiter.api.Test
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

        Test test = new Test();
        test.setListAPIs(new ArrayList<Api>());
        test.addAPI(api);

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
        test.removeAPI(api1);
        assertTrue(test.getListAPIs().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testRemoveAPI2() {
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

        Api api1 = new Api();
        api1.setPort(8080);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(true);
        api1.setPing(true);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(true);
        api1.setToken("ABC123");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api1);

        Test test = new Test();
        test.setListAPIs(apiList);
        test.addAPI(api);

        Api api2 = new Api();
        api2.setPort(8080);
        api2.setIp("127.0.0.1");
        api2.setStatus(true);
        api2.setDb(true);
        api2.setPing(true);
        api2.setAnomalies(new ArrayList<Anomalie>());
        api2.setId(123L);
        api2.setName("Name");
        api2.setDiskspace(true);
        api2.setToken("ABC123");
        api2.setDescription("The characteristics of someone or something");
        api2.setContexts(new ArrayList<Context>());
        test.removeAPI(api2);
        assertEquals(1, test.getListAPIs().size());
    }
}

