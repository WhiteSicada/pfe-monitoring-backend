package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.dto.test.TestDto;
import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TestConvertor.class})
@ExtendWith(SpringExtension.class)
class TestConvertorTest {
    @MockBean
    private ApiRepository apiRepository;

    @Autowired
    private TestConvertor testConvertor;

    @MockBean
    private TestRepository testRepository;

    @org.junit.jupiter.api.Test
    void testEntityToDto() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        TestDto actualEntityToDtoResult = this.testConvertor.entityToDto(test);
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
        assertEquals("Name", actualEntityToDtoResult.getName());
        assertTrue(actualEntityToDtoResult.getListAPIs().isEmpty());
        assertEquals(42L, actualEntityToDtoResult.getInterval().longValue());
    }

    @org.junit.jupiter.api.Test
    void testEntitysToDtos() {
        assertTrue(this.testConvertor.entitysToDtos(new ArrayList<com.bcp.monitoring.model.Test>()).isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testEntitysToDtos2() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");

        ArrayList<com.bcp.monitoring.model.Test> testList = new ArrayList<com.bcp.monitoring.model.Test>();
        testList.add(test);
        List<TestDto> actualEntitysToDtosResult = this.testConvertor.entitysToDtos(testList);
        assertEquals(1, actualEntitysToDtosResult.size());
        TestDto getResult = actualEntitysToDtosResult.get(0);
        assertEquals(123L, getResult.getId().longValue());
        assertEquals("Name", getResult.getName());
        assertTrue(getResult.getListAPIs().isEmpty());
        assertEquals(42L, getResult.getInterval().longValue());
    }

    @org.junit.jupiter.api.Test
    void testEntitysToDtos3() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");

        com.bcp.monitoring.model.Test test1 = new com.bcp.monitoring.model.Test();
        ArrayList<Api> apiList = new ArrayList<Api>();
        test1.setListAPIs(apiList);
        test1.setInterval(42L);
        test1.setId(123L);
        test1.setName("Name");

        ArrayList<com.bcp.monitoring.model.Test> testList = new ArrayList<com.bcp.monitoring.model.Test>();
        testList.add(test1);
        testList.add(test);
        List<TestDto> actualEntitysToDtosResult = this.testConvertor.entitysToDtos(testList);
        assertEquals(2, actualEntitysToDtosResult.size());
        TestDto getResult = actualEntitysToDtosResult.get(1);
        assertEquals("Name", getResult.getName());
        List<Api> listAPIs = getResult.getListAPIs();
        assertEquals(apiList, listAPIs);
        assertEquals(42L, getResult.getInterval().longValue());
        assertEquals(123L, getResult.getId().longValue());
        TestDto getResult1 = actualEntitysToDtosResult.get(0);
        assertEquals("Name", getResult1.getName());
        assertEquals(listAPIs, getResult1.getListAPIs());
        assertEquals(42L, getResult1.getInterval().longValue());
        assertEquals(123L, getResult1.getId().longValue());
    }

    @org.junit.jupiter.api.Test
    void testDtoToEntity() {
        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        this.testConvertor.dtoToEntity(testDto, test);
        assertEquals(123L, test.getId().longValue());
        assertEquals("Name", test.getName());
        assertEquals(42L, test.getInterval().longValue());
    }

    @org.junit.jupiter.api.Test
    void testDtoToEntity2() {
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
        Optional<Api> ofResult = Optional.<Api>of(api);
        when(this.apiRepository.findByName(anyString())).thenReturn(ofResult);

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

        TestDto testDto = new TestDto();
        testDto.setListAPIs(apiList);
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        this.testConvertor.dtoToEntity(testDto, test);
        verify(this.apiRepository).findByName(anyString());
        assertEquals(123L, test.getId().longValue());
        assertEquals("Name", test.getName());
        assertEquals(1, test.getListAPIs().size());
        assertEquals(42L, test.getInterval().longValue());
    }

    @org.junit.jupiter.api.Test
    void testDtoToEntity3() {
        when(this.apiRepository.findByName(anyString())).thenReturn(Optional.<Api>empty());

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

        TestDto testDto = new TestDto();
        testDto.setListAPIs(apiList);
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        this.testConvertor.dtoToEntity(testDto, test);
        verify(this.apiRepository).findByName(anyString());
        assertEquals(123L, test.getId().longValue());
        assertEquals("Name", test.getName());
        assertEquals(42L, test.getInterval().longValue());
    }

    @org.junit.jupiter.api.Test
    void testDtoToEntity4() {
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
        Optional<Api> ofResult = Optional.<Api>of(api);
        when(this.apiRepository.findByName(anyString())).thenReturn(ofResult);

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

        ArrayList<Api> apiList = new ArrayList<Api>();
        apiList.add(api2);
        apiList.add(api1);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(apiList);
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");

        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        this.testConvertor.dtoToEntity(testDto, test);
        verify(this.apiRepository, times(2)).findByName(anyString());
        assertEquals(123L, test.getId().longValue());
        assertEquals("Name", test.getName());
        assertEquals(2, test.getListAPIs().size());
        assertEquals(42L, test.getInterval().longValue());
    }
}

