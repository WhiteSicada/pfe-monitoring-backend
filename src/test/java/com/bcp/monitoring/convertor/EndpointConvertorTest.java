package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcp.monitoring.dto.endpoint.EndpointDto;
import com.bcp.monitoring.model.Endpoint;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EndpointConvertor.class})
@ExtendWith(SpringExtension.class)
class EndpointConvertorTest {
    @Autowired
    private EndpointConvertor endpointConvertor;

    @Test
    void testEntityToDoto() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        EndpointDto actualEntityToDotoResult = this.endpointConvertor.entityToDoto(endpoint);
        assertEquals("Data", actualEntityToDotoResult.getData());
        assertEquals("https://example.org/example", actualEntityToDotoResult.getUrl());
        assertEquals("Name", actualEntityToDotoResult.getName());
        assertEquals("Method", actualEntityToDotoResult.getMethod());
        assertEquals(123L, actualEntityToDotoResult.getId().longValue());
    }

    @Test
    void testEntityToDoto2() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        EndpointDto actualEntityToDotoResult = this.endpointConvertor.entityToDoto(endpoint);
        assertEquals("Data", actualEntityToDotoResult.getData());
        assertEquals("https://example.org/example", actualEntityToDotoResult.getUrl());
        assertEquals("Name", actualEntityToDotoResult.getName());
        assertEquals("Method", actualEntityToDotoResult.getMethod());
        assertEquals(123L, actualEntityToDotoResult.getId().longValue());
    }

    @Test
    void testEntitiesToDotos() {
        assertTrue(this.endpointConvertor.entitiesToDotos(new ArrayList<Endpoint>()).isEmpty());
        assertTrue(this.endpointConvertor.entitiesToDotos(new ArrayList<Endpoint>()).isEmpty());
    }

    @Test
    void testEntitiesToDotos2() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ArrayList<Endpoint> endpointList = new ArrayList<Endpoint>();
        endpointList.add(endpoint);
        assertEquals(1, this.endpointConvertor.entitiesToDotos(endpointList).size());
    }

    @Test
    void testEntitiesToDotos3() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");

        ArrayList<Endpoint> endpointList = new ArrayList<Endpoint>();
        endpointList.add(endpoint1);
        endpointList.add(endpoint);
        assertEquals(2, this.endpointConvertor.entitiesToDotos(endpointList).size());
    }

    @Test
    void testEntitiesToDotos4() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ArrayList<Endpoint> endpointList = new ArrayList<Endpoint>();
        endpointList.add(endpoint);
        assertEquals(1, this.endpointConvertor.entitiesToDotos(endpointList).size());
    }

    @Test
    void testEntitiesToDotos5() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");

        ArrayList<Endpoint> endpointList = new ArrayList<Endpoint>();
        endpointList.add(endpoint1);
        endpointList.add(endpoint);
        assertEquals(2, this.endpointConvertor.entitiesToDotos(endpointList).size());
    }

    @Test
    void testDtoToEntity() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");
        this.endpointConvertor.dtoToEntity(endpoint, endpoint1);
        assertEquals("Data", endpoint1.getData());
        assertEquals("https://example.org/example", endpoint1.getUrl());
        assertEquals("Name", endpoint1.getName());
        assertEquals("Method", endpoint1.getMethod());
        assertEquals(123L, endpoint1.getId().longValue());
    }

    @Test
    void testDtoToEntity2() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");
        this.endpointConvertor.dtoToEntity(endpoint, endpoint1);
        assertEquals("Data", endpoint1.getData());
        assertEquals("https://example.org/example", endpoint1.getUrl());
        assertEquals("Name", endpoint1.getName());
        assertEquals("Method", endpoint1.getMethod());
        assertEquals(123L, endpoint1.getId().longValue());
    }
}

