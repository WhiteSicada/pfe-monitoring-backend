package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcp.monitoring.dto.api.ApiDto;
import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.repository.AnomalieRepository;
import com.bcp.monitoring.repository.EndpointRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EndpointConvertor.class, ApiConvertor.class})
@ExtendWith(SpringExtension.class)
class ApiConvertorTest {
    @MockBean
    private AnomalieRepository anomalieRepository;

    @Autowired
    private ApiConvertor apiConvertor;

    @MockBean
    private EndpointConvertor endpointConvertor;

    @MockBean
    private EndpointRepository endpointRepository;

    @Test
    void testEntityToDto() {
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
        ArrayList<Context> contextList = new ArrayList<Context>();
        api.setContexts(contextList);
        ApiDto actualEntityToDtoResult = this.apiConvertor.entityToDto(api);
        List<Anomalie> anomalieList = actualEntityToDtoResult.getAnomalieList();
        assertEquals(contextList, anomalieList);
        assertTrue(actualEntityToDtoResult.isStatus());
        assertTrue(actualEntityToDtoResult.isPing());
        assertTrue(actualEntityToDtoResult.isDiskspace());
        assertTrue(actualEntityToDtoResult.isDb());
        assertEquals("ABC123", actualEntityToDtoResult.getToken());
        assertEquals(8080, actualEntityToDtoResult.getPort());
        assertEquals("Name", actualEntityToDtoResult.getName());
        assertEquals("127.0.0.1", actualEntityToDtoResult.getIp());
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
        assertEquals("The characteristics of someone or something", actualEntityToDtoResult.getDescription());
        assertEquals(anomalieList, actualEntityToDtoResult.getContexts());
    }

    @Test
    void testEntityToDto2() {
        Api api = new Api();
        api.setPort(8080);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(true);
        api.setPing(true);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(true);
        api.setToken("ABC123");
        api.setDescription("The characteristics of someone or something");
        ArrayList<Context> contextList = new ArrayList<Context>();
        api.setContexts(contextList);
        ApiDto actualEntityToDtoResult = this.apiConvertor.entityToDto(api);
        List<Anomalie> anomalieList = actualEntityToDtoResult.getAnomalieList();
        assertEquals(contextList, anomalieList);
        assertFalse(actualEntityToDtoResult.isStatus());
        assertTrue(actualEntityToDtoResult.isPing());
        assertTrue(actualEntityToDtoResult.isDiskspace());
        assertTrue(actualEntityToDtoResult.isDb());
        assertEquals("ABC123", actualEntityToDtoResult.getToken());
        assertEquals(8080, actualEntityToDtoResult.getPort());
        assertEquals("Name", actualEntityToDtoResult.getName());
        assertEquals("127.0.0.1", actualEntityToDtoResult.getIp());
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
        assertEquals("The characteristics of someone or something", actualEntityToDtoResult.getDescription());
        assertEquals(anomalieList, actualEntityToDtoResult.getContexts());
    }

    @Test
    void testEntitiesToDtos() {
        assertTrue(this.apiConvertor.entitiesToDtos(new ArrayList<Api>()).isEmpty());
    }

    @Test
    void testEntitiesToDtos2() {
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

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api);
        assertEquals(1, this.apiConvertor.entitiesToDtos(apiList).size());
    }

    @Test
    void testEntitiesToDtos3() {
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

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api1);
        apiList.add(api);
        assertEquals(2, this.apiConvertor.entitiesToDtos(apiList).size());
    }

    @Test
    void testEntitiesToDtos4() {
        Api api = new Api();
        api.setPort(8080);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(true);
        api.setPing(true);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(true);
        api.setToken("ABC123");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api);
        assertEquals(1, this.apiConvertor.entitiesToDtos(apiList).size());
    }

    @Test
    void testDtoToEntity() {
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
        this.apiConvertor.dtoToEntity(apiDto, api);
        assertTrue(api.isStatus());
        assertTrue(api.isPing());
        assertTrue(api.isDiskspace());
        assertTrue(api.isDb());
        assertEquals("ABC123", api.getToken());
        assertEquals(8080, api.getPort());
        assertEquals("Name", api.getName());
        assertEquals("127.0.0.1", api.getIp());
        assertEquals(123L, api.getId().longValue());
        assertEquals("The characteristics of someone or something", api.getDescription());
    }

    @Test
    void testDtoToEntity2() {
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
        this.apiConvertor.dtoToEntity(apiDto, api);
        assertFalse(api.isStatus());
        assertTrue(api.isPing());
        assertTrue(api.isDiskspace());
        assertTrue(api.isDb());
        assertEquals("ABC123", api.getToken());
        assertEquals(8080, api.getPort());
        assertEquals("Name", api.getName());
        assertEquals("127.0.0.1", api.getIp());
        assertEquals(123L, api.getId().longValue());
        assertEquals("The characteristics of someone or something", api.getDescription());
    }
}

