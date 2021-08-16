package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcp.monitoring.dto.scan.ScanDtoShow;
import com.bcp.monitoring.model.Scan;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.EndpointRepository;
import com.bcp.monitoring.repository.TestRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ScanConvertor.class})
@ExtendWith(SpringExtension.class)
class ScanConvertorTest {
    @MockBean
    private ApiRepository apiRepository;

    @MockBean
    private EndpointRepository endpointRepository;

    @Autowired
    private ScanConvertor scanConvertor;

    @MockBean
    private TestRepository testRepository;

    @Test
    void testEntityToDoto() {
        Scan scan = new Scan();
        scan.setExecutionTime("Execution Time");
        scan.setSpark("Spark");
        scan.setStatus("Status");
        scan.setApi("Api");
        scan.setId(123L);
        scan.setUrl("https://example.org/example");
        scan.setCreatesAt("Creates At");
        scan.setSuccessful("Successful");
        scan.setMethod("Method");
        scan.setTest("Test");
        ScanDtoShow actualEntityToDotoResult = this.scanConvertor.entityToDoto(scan);
        assertEquals("Api", actualEntityToDotoResult.getApi());
        assertEquals("https://example.org/example", actualEntityToDotoResult.getUrl());
        assertEquals("Test", actualEntityToDotoResult.getTest());
        assertEquals("Successful", actualEntityToDotoResult.getSuccessful());
        assertEquals("Status", actualEntityToDotoResult.getStatus());
        assertEquals("Spark", actualEntityToDotoResult.getSpark());
        assertEquals("Method", actualEntityToDotoResult.getMethod());
        assertEquals(123L, actualEntityToDotoResult.getId().longValue());
        assertEquals("Execution Time", actualEntityToDotoResult.getExecutionTime());
        assertEquals("Creates At", actualEntityToDotoResult.getCreatesAt());
    }

    @Test
    void testEntitiesToDotos() {
        assertTrue(this.scanConvertor.entitiesToDotos(new ArrayList<Scan>()).isEmpty());
    }

    @Test
    void testEntitiesToDotos2() {
        Scan scan = new Scan();
        scan.setExecutionTime("Execution Time");
        scan.setSpark("Spark");
        scan.setStatus("Status");
        scan.setApi("Api");
        scan.setId(123L);
        scan.setUrl("https://example.org/example");
        scan.setCreatesAt("Creates At");
        scan.setSuccessful("Successful");
        scan.setMethod("Method");
        scan.setTest("Test");

        ArrayList<Scan> scanList = new ArrayList<Scan>();
        scanList.add(scan);
        assertEquals(1, this.scanConvertor.entitiesToDotos(scanList).size());
    }

    @Test
    void testEntitiesToDotos3() {
        Scan scan = new Scan();
        scan.setExecutionTime("Execution Time");
        scan.setSpark("Spark");
        scan.setStatus("Status");
        scan.setApi("Api");
        scan.setId(123L);
        scan.setUrl("https://example.org/example");
        scan.setCreatesAt("Creates At");
        scan.setSuccessful("Successful");
        scan.setMethod("Method");
        scan.setTest("Test");

        Scan scan1 = new Scan();
        scan1.setExecutionTime("Execution Time");
        scan1.setSpark("Spark");
        scan1.setStatus("Status");
        scan1.setApi("Api");
        scan1.setId(123L);
        scan1.setUrl("https://example.org/example");
        scan1.setCreatesAt("Creates At");
        scan1.setSuccessful("Successful");
        scan1.setMethod("Method");
        scan1.setTest("Test");

        ArrayList<Scan> scanList = new ArrayList<Scan>();
        scanList.add(scan1);
        scanList.add(scan);
        assertEquals(2, this.scanConvertor.entitiesToDotos(scanList).size());
    }
}

