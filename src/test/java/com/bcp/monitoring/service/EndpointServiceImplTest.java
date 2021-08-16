package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.EndpointConvertor;
import com.bcp.monitoring.dto.endpoint.EndpointDto;
import com.bcp.monitoring.model.Endpoint;
import com.bcp.monitoring.repository.EndpointRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EndpointConvertor.class, EndpointServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EndpointServiceImplTest {
    @MockBean
    private EndpointConvertor endpointConvertor;

    @MockBean
    private EndpointRepository endpointRepository;

    @Autowired
    private EndpointServiceImpl endpointServiceImpl;

    @Test
    void testCreateEndpoint() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        when(this.endpointRepository.save((Endpoint) any())).thenReturn(endpoint);

        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");
        when(this.endpointConvertor.entityToDoto((Endpoint) any())).thenReturn(endpointDto);

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");
        assertSame(endpointDto, this.endpointServiceImpl.createEndpoint(endpoint1));
        verify(this.endpointRepository).save((Endpoint) any());
        verify(this.endpointConvertor).entityToDoto((Endpoint) any());
        assertTrue(this.endpointServiceImpl.getEndpointList().isEmpty());
    }

    @Test
    void testUpdateEndpoint() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");
        when(this.endpointRepository.save((Endpoint) any())).thenReturn(endpoint1);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);

        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");
        when(this.endpointConvertor.entityToDoto((Endpoint) any())).thenReturn(endpointDto);
        doNothing().when(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());

        Endpoint endpoint2 = new Endpoint();
        endpoint2.setId(123L);
        endpoint2.setUrl("https://example.org/example");
        endpoint2.setName("Name");
        endpoint2.setData("Data");
        endpoint2.setMethod("Method");
        assertSame(endpointDto, this.endpointServiceImpl.updateEndpoint(123L, endpoint2));
        verify(this.endpointRepository).findById((Long) any());
        verify(this.endpointRepository).save((Endpoint) any());
        verify(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());
        verify(this.endpointConvertor).entityToDoto((Endpoint) any());
        assertTrue(this.endpointServiceImpl.getEndpointList().isEmpty());
    }

    @Test
    void testUpdateEndpoint2() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        when(this.endpointRepository.save((Endpoint) any())).thenReturn(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(Optional.<Endpoint>empty());

        EndpointDto endpointDto = new EndpointDto();
        endpointDto.setId(123L);
        endpointDto.setUrl("https://example.org/example");
        endpointDto.setName("Name");
        endpointDto.setData("Data");
        endpointDto.setMethod("Method");
        when(this.endpointConvertor.entityToDoto((Endpoint) any())).thenReturn(endpointDto);
        doNothing().when(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");
        assertNull(this.endpointServiceImpl.updateEndpoint(123L, endpoint1));
        verify(this.endpointRepository).findById((Long) any());
        assertTrue(this.endpointServiceImpl.getEndpointList().isEmpty());
    }

    @Test
    void testDeleteEndpoint() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        doNothing().when(this.endpointRepository).deleteById((Long) any());
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Endpoint with id: 123 deleted successfully!", this.endpointServiceImpl.deleteEndpoint(123L));
        verify(this.endpointRepository).deleteById((Long) any());
        verify(this.endpointRepository).findById((Long) any());
        assertTrue(this.endpointServiceImpl.getEndpointList().isEmpty());
    }

    @Test
    void testDeleteEndpoint2() {
        doNothing().when(this.endpointRepository).deleteById((Long) any());
        when(this.endpointRepository.findById((Long) any())).thenReturn(Optional.<Endpoint>empty());
        assertEquals("Endpoint with id: 123 not deleted successfully!", this.endpointServiceImpl.deleteEndpoint(123L));
        verify(this.endpointRepository).findById((Long) any());
        assertTrue(this.endpointServiceImpl.getEndpointList().isEmpty());
    }

    @Test
    void testGetEndpointList() {
        when(this.endpointRepository.findAll()).thenReturn(new ArrayList<Endpoint>());
        ArrayList<EndpointDto> endpointDtoList = new ArrayList<EndpointDto>();
        when(this.endpointConvertor.entitiesToDotos((List<Endpoint>) any())).thenReturn(endpointDtoList);
        List<EndpointDto> actualEndpointList = this.endpointServiceImpl.getEndpointList();
        assertSame(endpointDtoList, actualEndpointList);
        assertTrue(actualEndpointList.isEmpty());
        verify(this.endpointRepository).findAll();
        verify(this.endpointConvertor).entitiesToDotos((List<Endpoint>) any());
    }
}

