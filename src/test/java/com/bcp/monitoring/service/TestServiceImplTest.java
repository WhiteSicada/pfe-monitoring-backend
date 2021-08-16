package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.ScanConvertor;
import com.bcp.monitoring.convertor.TestConvertor;
import com.bcp.monitoring.dto.api.ListApisDto;
import com.bcp.monitoring.dto.scan.ScanDtoShow;
import com.bcp.monitoring.dto.test.TestDto;
import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.model.Scan;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.ScanRepository;
import com.bcp.monitoring.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ScanConvertor.class, TestServiceImpl.class, TestConvertor.class})
@ExtendWith(SpringExtension.class)
class TestServiceImplTest {
    @MockBean
    private ApiRepository apiRepository;

    @MockBean
    private ScanConvertor scanConvertor;

    @MockBean
    private ScanRepository scanRepository;

    @MockBean
    private TestConvertor testConvertor;

    @MockBean
    private TestRepository testRepository;

    @Autowired
    private TestServiceImpl testServiceImpl;

    @org.junit.jupiter.api.Test
    void testCreateTest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);
        doNothing().when(this.testConvertor).dtoToEntity((TestDto) any(), (com.bcp.monitoring.model.Test) any());

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertSame(testDto, this.testServiceImpl.createTest(testDto1));
        verify(this.testRepository).save((com.bcp.monitoring.model.Test) any());
        verify(this.testConvertor).dtoToEntity((TestDto) any(), (com.bcp.monitoring.model.Test) any());
        verify(this.testConvertor).entityToDto((com.bcp.monitoring.model.Test) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testUpdateTest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);

        com.bcp.monitoring.model.Test test1 = new com.bcp.monitoring.model.Test();
        test1.setListAPIs(new ArrayList<Api>());
        test1.setInterval(42L);
        test1.setId(123L);
        test1.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test1);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);
        doNothing().when(this.testConvertor).dtoToEntity((TestDto) any(), (com.bcp.monitoring.model.Test) any());

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertSame(testDto, this.testServiceImpl.updateTest(123L, testDto1));
        verify(this.testRepository).findById((Long) any());
        verify(this.testRepository).save((com.bcp.monitoring.model.Test) any());
        verify(this.testConvertor).dtoToEntity((TestDto) any(), (com.bcp.monitoring.model.Test) any());
        verify(this.testConvertor).entityToDto((com.bcp.monitoring.model.Test) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testUpdateTest2() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test);
        when(this.testRepository.findById((Long) any())).thenReturn(Optional.<com.bcp.monitoring.model.Test>empty());

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);
        doNothing().when(this.testConvertor).dtoToEntity((TestDto) any(), (com.bcp.monitoring.model.Test) any());

        TestDto testDto1 = new TestDto();
        testDto1.setListAPIs(new ArrayList<Api>());
        testDto1.setInterval(42L);
        testDto1.setId(123L);
        testDto1.setName("Name");
        assertNull(this.testServiceImpl.updateTest(123L, testDto1));
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testDeleteTest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);
        doNothing().when(this.testRepository).deleteById((Long) any());
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Test with id: 123 deleted successfully!", this.testServiceImpl.deleteTest(123L));
        verify(this.testRepository).deleteById((Long) any());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testDeleteTest2() {
        doNothing().when(this.testRepository).deleteById((Long) any());
        when(this.testRepository.findById((Long) any())).thenReturn(Optional.<com.bcp.monitoring.model.Test>empty());
        assertEquals("Test with id: 123 does not exists!", this.testServiceImpl.deleteTest(123L));
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testGetTestList() {
        when(this.testRepository.findAll()).thenReturn(new ArrayList<com.bcp.monitoring.model.Test>());
        ArrayList<TestDto> testDtoList = new ArrayList<TestDto>();
        when(this.testConvertor.entitysToDtos((List<com.bcp.monitoring.model.Test>) any())).thenReturn(testDtoList);
        List<TestDto> actualTestList = this.testServiceImpl.getTestList();
        assertSame(testDtoList, actualTestList);
        assertTrue(actualTestList.isEmpty());
        verify(this.testRepository).findAll();
        verify(this.testConvertor).entitysToDtos((List<com.bcp.monitoring.model.Test>) any());
    }

    @org.junit.jupiter.api.Test
    void testGetTestScans() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);
        when(this.scanRepository.findAllByTestOrderByIdDesc(anyString())).thenReturn(new ArrayList<Scan>());
        ArrayList<ScanDtoShow> scanDtoShowList = new ArrayList<ScanDtoShow>();
        when(this.scanConvertor.entitiesToDotos((List<Scan>) any())).thenReturn(scanDtoShowList);
        List<ScanDtoShow> actualTestScans = this.testServiceImpl.getTestScans(123L);
        assertSame(scanDtoShowList, actualTestScans);
        assertTrue(actualTestScans.isEmpty());
        verify(this.testRepository).findById((Long) any());
        verify(this.scanRepository).findAllByTestOrderByIdDesc(anyString());
        verify(this.scanConvertor).entitiesToDotos((List<Scan>) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testGetTestScans2() {
        when(this.testRepository.findById((Long) any())).thenReturn(Optional.<com.bcp.monitoring.model.Test>empty());
        when(this.scanRepository.findAllByTestOrderByIdDesc(anyString())).thenReturn(new ArrayList<Scan>());
        when(this.scanConvertor.entitiesToDotos((List<Scan>) any())).thenReturn(new ArrayList<ScanDtoShow>());
        assertTrue(this.testServiceImpl.getTestScans(123L).isEmpty());
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testAddApisToTest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);

        com.bcp.monitoring.model.Test test1 = new com.bcp.monitoring.model.Test();
        test1.setListAPIs(new ArrayList<Api>());
        test1.setInterval(42L);
        test1.setId(123L);
        test1.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test1);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);

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
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findByName(anyString())).thenReturn(ofResult1);

        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertSame(testDto, this.testServiceImpl.addApisToTest(123L, listApisDto));
        verify(this.testRepository).findById((Long) any());
        verify(this.testRepository).save((com.bcp.monitoring.model.Test) any());
        verify(this.testConvertor).entityToDto((com.bcp.monitoring.model.Test) any());
        verify(this.apiRepository).findByName(anyString());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testAddApisToTest2() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test);
        when(this.testRepository.findById((Long) any())).thenReturn(Optional.<com.bcp.monitoring.model.Test>empty());

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);

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

        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertNull(this.testServiceImpl.addApisToTest(123L, listApisDto));
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testAddApisToTest3() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);

        com.bcp.monitoring.model.Test test1 = new com.bcp.monitoring.model.Test();
        test1.setListAPIs(new ArrayList<Api>());
        test1.setInterval(42L);
        test1.setId(123L);
        test1.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test1);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);
        when(this.apiRepository.findByName(anyString())).thenReturn(Optional.<Api>empty());

        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertNull(this.testServiceImpl.addApisToTest(123L, listApisDto));
        verify(this.testRepository).findById((Long) any());
        verify(this.apiRepository).findByName(anyString());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testRemoveApisFromTest() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);

        com.bcp.monitoring.model.Test test1 = new com.bcp.monitoring.model.Test();
        test1.setListAPIs(new ArrayList<Api>());
        test1.setInterval(42L);
        test1.setId(123L);
        test1.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test1);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);

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
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findByName(anyString())).thenReturn(ofResult1);

        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertSame(testDto, this.testServiceImpl.removeApisFromTest(123L, listApisDto));
        verify(this.testRepository).findById((Long) any());
        verify(this.testRepository).save((com.bcp.monitoring.model.Test) any());
        verify(this.testConvertor).entityToDto((com.bcp.monitoring.model.Test) any());
        verify(this.apiRepository).findByName(anyString());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testRemoveApisFromTest2() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test);
        when(this.testRepository.findById((Long) any())).thenReturn(Optional.<com.bcp.monitoring.model.Test>empty());

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);

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

        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertNull(this.testServiceImpl.removeApisFromTest(123L, listApisDto));
        verify(this.testRepository).findById((Long) any());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testRemoveApisFromTest3() {
        com.bcp.monitoring.model.Test test = new com.bcp.monitoring.model.Test();
        test.setListAPIs(new ArrayList<Api>());
        test.setInterval(42L);
        test.setId(123L);
        test.setName("Name");
        Optional<com.bcp.monitoring.model.Test> ofResult = Optional.<com.bcp.monitoring.model.Test>of(test);

        com.bcp.monitoring.model.Test test1 = new com.bcp.monitoring.model.Test();
        test1.setListAPIs(new ArrayList<Api>());
        test1.setInterval(42L);
        test1.setId(123L);
        test1.setName("Name");
        when(this.testRepository.save((com.bcp.monitoring.model.Test) any())).thenReturn(test1);
        when(this.testRepository.findById((Long) any())).thenReturn(ofResult);

        TestDto testDto = new TestDto();
        testDto.setListAPIs(new ArrayList<Api>());
        testDto.setInterval(42L);
        testDto.setId(123L);
        testDto.setName("Name");
        when(this.testConvertor.entityToDto((com.bcp.monitoring.model.Test) any())).thenReturn(testDto);
        when(this.apiRepository.findByName(anyString())).thenReturn(Optional.<Api>empty());

        ListApisDto listApisDto = new ListApisDto();
        listApisDto.setApis(new String[]{"Apis"});
        assertNull(this.testServiceImpl.removeApisFromTest(123L, listApisDto));
        verify(this.testRepository).findById((Long) any());
        verify(this.apiRepository).findByName(anyString());
        assertTrue(this.testServiceImpl.getTestList().isEmpty());
    }
}

