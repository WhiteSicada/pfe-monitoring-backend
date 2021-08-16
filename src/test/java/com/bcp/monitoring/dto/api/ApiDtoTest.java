package com.bcp.monitoring.dto.api;

import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.model.Endpoint;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiDtoTest {
    @Test
    void testCanEqual() {
        assertFalse((new ApiDto()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ApiDto apiDto = new ApiDto();

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertTrue(apiDto.canEqual(apiDto1));
    }

    @Test
    void testConstructor() {
        ApiDto actualApiDto = new ApiDto();
        ArrayList<Anomalie> anomalieList = new ArrayList<Anomalie>();
        actualApiDto.setAnomalieList(anomalieList);
        ArrayList<Context> contextList = new ArrayList<Context>();
        actualApiDto.setContexts(contextList);
        actualApiDto.setDb(true);
        actualApiDto.setDescription("The characteristics of someone or something");
        actualApiDto.setDiskspace(true);
        actualApiDto.setId(123L);
        actualApiDto.setIp("127.0.0.1");
        actualApiDto.setName("Name");
        actualApiDto.setPing(true);
        actualApiDto.setPort(8080);
        actualApiDto.setStatus(true);
        actualApiDto.setToken("ABC123");
        List<Anomalie> anomalieList1 = actualApiDto.getAnomalieList();
        assertSame(anomalieList, anomalieList1);
        assertEquals(contextList, anomalieList1);
        List<Context> contexts = actualApiDto.getContexts();
        assertSame(contextList, contexts);
        assertEquals(anomalieList1, contexts);
        assertEquals("The characteristics of someone or something", actualApiDto.getDescription());
        assertEquals(123L, actualApiDto.getId().longValue());
        assertEquals("127.0.0.1", actualApiDto.getIp());
        assertEquals("Name", actualApiDto.getName());
        assertEquals(8080, actualApiDto.getPort());
        assertEquals("ABC123", actualApiDto.getToken());
        assertTrue(actualApiDto.isDb());
        assertTrue(actualApiDto.isDiskspace());
        assertTrue(actualApiDto.isPing());
        assertTrue(actualApiDto.isStatus());
        assertEquals("ApiDto(id=123, name=Name, description=The characteristics of someone or something, ip=127.0.0.1,"
                + " port=8080, token=ABC123, status=true, db=true, diskspace=true, ping=true, contexts=[],"
                + " anomalieList=[])", actualApiDto.toString());
    }

    @Test
    void testEquals() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        assertNotEquals(null,apiDto);
    }

    @Test
    void testEquals10() {
        Anomalie anomalie = new Anomalie();
        anomalie.setFixed(true);
        anomalie.setId(123L);
        anomalie.setEndpoint("https://config.us-east-2.amazonaws.com");
        anomalie.setDate("2020-03-01");
        anomalie.setError("An error occurred");

        ArrayList<Anomalie> anomalieList = new ArrayList<Anomalie>();
        anomalieList.add(anomalie);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(anomalieList);
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals11() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals12() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(0L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals13() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(null);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals14() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName(null);
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals15() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("The characteristics of someone or something");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals16() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals17() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("Name");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals18() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken(null);
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals19() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("Name");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals2() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        assertNotEquals("Different type to ApiDto",apiDto);
    }

    @Test
    void testEquals20() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription(null);
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals21() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        ArrayList<Context> contextList = new ArrayList<Context>();
        contextList.add(context);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(contextList);

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals3() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        assertEquals(apiDto,apiDto);
        int expectedHashCodeResult = apiDto.hashCode();
        assertEquals(expectedHashCodeResult, apiDto.hashCode());
    }

    @Test
    void testEquals4() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertEquals(apiDto,apiDto);
        int expectedHashCodeResult = apiDto.hashCode();
        assertEquals(expectedHashCodeResult, apiDto1.hashCode());
    }

    @Test
    void testEquals5() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(0);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals6() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("Name");
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals7() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp(null);
        apiDto.setStatus(true);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals8() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(true);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }

    @Test
    void testEquals9() {
        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8080);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(true);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(true);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(true);
        apiDto.setToken("ABC123");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());

        ApiDto apiDto1 = new ApiDto();
        apiDto1.setPort(8080);
        apiDto1.setIp("127.0.0.1");
        apiDto1.setStatus(true);
        apiDto1.setDb(true);
        apiDto1.setAnomalieList(new ArrayList<Anomalie>());
        apiDto1.setPing(true);
        apiDto1.setId(123L);
        apiDto1.setName("Name");
        apiDto1.setDiskspace(true);
        apiDto1.setToken("ABC123");
        apiDto1.setDescription("The characteristics of someone or something");
        apiDto1.setContexts(new ArrayList<Context>());
        assertNotEquals(apiDto,apiDto1);
    }
}

