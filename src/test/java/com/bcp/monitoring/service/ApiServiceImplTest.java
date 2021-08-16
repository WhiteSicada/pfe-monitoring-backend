package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.ApiConvertor;
import com.bcp.monitoring.convertor.ContextConvertor;
import com.bcp.monitoring.convertor.EndpointConvertor;
import com.bcp.monitoring.dto.api.ApiDto;
import com.bcp.monitoring.dto.contexts.ContextUpdateDto;
import com.bcp.monitoring.dto.contexts.ListContextsIds;
import com.bcp.monitoring.dto.contexts.ListContextsObjects;
import com.bcp.monitoring.dto.contexts.LitsContextsNames;
import com.bcp.monitoring.dto.endpoint.ListEndpointDto;
import com.bcp.monitoring.dto.endpoint.ListEndpointIds;
import com.bcp.monitoring.model.Anomalie;
import com.bcp.monitoring.model.Api;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.model.Endpoint;
import com.bcp.monitoring.repository.ApiRepository;
import com.bcp.monitoring.repository.ContextRepository;
import com.bcp.monitoring.repository.EndpointRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

@ContextConfiguration(classes = {ApiServiceImpl.class, EndpointConvertor.class, ApiConvertor.class,
        ContextConvertor.class})
@ExtendWith(SpringExtension.class)
class ApiServiceImplTest {
    @MockBean
    private ApiConvertor apiConvertor;

    @MockBean
    private ApiRepository apiRepository;

    @Autowired
    private ApiServiceImpl apiServiceImpl;

    @MockBean
    private ContextConvertor contextConvertor;

    @MockBean
    private ContextRepository contextRepository;

    @MockBean
    private EndpointConvertor endpointConvertor;

    @MockBean
    private EndpointRepository endpointRepository;

    @Test
    void testCreateApi() {
        doThrow(new HttpClientErrorException(HttpStatus.CONTINUE)).when(this.apiConvertor)
                .dtoToEntity((ApiDto) any(), (com.bcp.monitoring.model.Api) any());

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        assertThrows(HttpClientErrorException.class, () -> this.apiServiceImpl.createApi(apiDto));
        verify(this.apiConvertor).dtoToEntity((ApiDto) any(), (com.bcp.monitoring.model.Api) any());
    }

    @Test
    void testGetAllApis() {
        when(this.apiRepository.findAllByOrderByIdDesc()).thenReturn(new ArrayList<Api>());
        ArrayList<ApiDto> apiDtoList = new ArrayList<ApiDto>();
        when(this.apiConvertor.entitiesToDtos((List<Api>) any())).thenReturn(apiDtoList);
        List<ApiDto> actualAllApis = this.apiServiceImpl.getAllApis();
        assertSame(apiDtoList, actualAllApis);
        assertTrue(actualAllApis.isEmpty());
        verify(this.apiRepository).findAllByOrderByIdDesc();
        verify(this.apiConvertor).entitiesToDtos((List<Api>) any());
    }

    @Test
    void testGetApiById() {
        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(api, this.apiServiceImpl.getApiById(123L));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testGetApiById2() {
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());
        assertNull(this.apiServiceImpl.getApiById(123L));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateApi() {
        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.apiConvertor).dtoToEntity((ApiDto) any(), (Api) any());

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        assertEquals(123L, this.apiServiceImpl.updateApi(123L, apiDto).longValue());
        verify(this.apiRepository).findById((Long) any());
        verify(this.apiRepository).save((Api) any());
        verify(this.apiConvertor).dtoToEntity((ApiDto) any(), (Api) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateApi2() {
        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());
        doNothing().when(this.apiConvertor).dtoToEntity((ApiDto) any(), (Api) any());

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        assertNull(this.apiServiceImpl.updateApi(123L, apiDto));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testDeleteApi() {
        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);
        doNothing().when(this.apiRepository).deleteById((Long) any());
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Api with id: 123 deleted successfully!", this.apiServiceImpl.deleteApi(123L));
        verify(this.apiRepository).deleteById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testDeleteApi2() {
        doNothing().when(this.apiRepository).deleteById((Long) any());
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());
        assertEquals("Api with id: 123 not deleted successfully!", this.apiServiceImpl.deleteApi(123L));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddContextsToApi() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        when(this.contextRepository.findByName(anyString())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});
        assertNull(this.apiServiceImpl.addContextsToApi(123L, litsContextsNames));
        verify(this.contextRepository).findByName(anyString());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddContextsToApi2() {
        when(this.contextRepository.findByName(anyString())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});
        assertSame(apiDto, this.apiServiceImpl.addContextsToApi(123L, litsContextsNames));
        verify(this.contextRepository).findByName(anyString());
        verify(this.apiRepository).findById((Long) any());
        verify(this.apiRepository).save((Api) any());
        verify(this.apiConvertor).entityToDto((Api) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddContextsToApi3() {
        when(this.contextRepository.findByName(anyString())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        LitsContextsNames litsContextsNames = new LitsContextsNames();
        litsContextsNames.setContexts(new String[]{"Contexts"});
        assertNull(this.apiServiceImpl.addContextsToApi(123L, litsContextsNames));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveContextFromApi() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertSame(apiDto, this.apiServiceImpl.removeContextFromApi(123L, listContextsIds));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        verify(this.apiRepository).save((Api) any());
        verify(this.apiConvertor).entityToDto((Api) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveContextFromApi2() {
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertNull(this.apiServiceImpl.removeContextFromApi(123L, listContextsIds));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveContextFromApi3() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());

        ArrayList<Context> contextList = new ArrayList<Context>();
        contextList.add(context1);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(contextList);
        Optional<Api> ofResult1 = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertSame(apiDto, this.apiServiceImpl.removeContextFromApi(123L, listContextsIds));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        verify(this.apiRepository).save((Api) any());
        verify(this.apiConvertor).entityToDto((Api) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveContextFromApi4() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        ListContextsIds listContextsIds = new ListContextsIds();
        listContextsIds.setContexts(new Long[]{1L});
        assertNull(this.apiServiceImpl.removeContextFromApi(123L, listContextsIds));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateApiContexts() {
        when(this.contextRepository.findById((Long) any())).thenThrow(new HttpClientErrorException(HttpStatus.CONTINUE));

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);

        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertThrows(HttpClientErrorException.class,
                () -> this.apiServiceImpl.updateApiContexts(123L, listContextsObjects));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
    }

    @Test
    void testUpdateApiContexts2() {
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);

        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertNull(this.apiServiceImpl.updateApiContexts(123L, listContextsObjects));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateApiContexts3() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());

        ArrayList<Context> contextList = new ArrayList<Context>();
        contextList.add(context1);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(contextList);
        Optional<Api> ofResult1 = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        ContextUpdateDto contextUpdateDto = new ContextUpdateDto();
        contextUpdateDto.setId(123L);
        contextUpdateDto.setName("Name");

        ListContextsObjects listContextsObjects = new ListContextsObjects();
        listContextsObjects.setContexts(new ContextUpdateDto[]{contextUpdateDto});
        assertSame(apiDto, this.apiServiceImpl.updateApiContexts(123L, listContextsObjects));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        verify(this.apiRepository).save((Api) any());
        verify(this.apiConvertor).entityToDto((Api) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddEndpointsToContext() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findByName(anyString())).thenReturn(ofResult);

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult1 = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult1);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult2 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult2);

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint1});
        assertNull(this.apiServiceImpl.addEndpointsToContext(123L, 123L, listEndpointDto));
        verify(this.endpointRepository).findByName(anyString());
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddEndpointsToContext2() {
        when(this.endpointRepository.findByName(anyString())).thenReturn(Optional.<Endpoint>empty());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context1);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint});
        assertSame(apiDto, this.apiServiceImpl.addEndpointsToContext(123L, 123L, listEndpointDto));
        verify(this.endpointRepository).findByName(anyString());
        verify(this.contextRepository).findById((Long) any());
        verify(this.contextRepository).save((Context) any());
        verify(this.apiRepository).findById((Long) any());
        verify(this.apiRepository).save((Api) any());
        verify(this.apiConvertor).entityToDto((Api) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddEndpointsToContext3() {
        when(this.endpointRepository.findByName(anyString())).thenReturn(Optional.<Endpoint>empty());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);

        Api api1 = new Api();
        api1.setPort(8081);
        api1.setIp("127.0.0.1");
        api1.setStatus(false);
        api1.setDb(false);
        api1.setPing(false);
        api1.setAnomalies(new ArrayList<Anomalie>());
        api1.setId(123L);
        api1.setName("Name");
        api1.setDiskspace(false);
        api1.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api1.setDescription("The characteristics of someone or something");
        api1.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api1);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint});
        assertNull(this.apiServiceImpl.addEndpointsToContext(123L, 123L, listEndpointDto));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testAddEndpointsToContext4() {
        when(this.endpointRepository.findByName(anyString())).thenReturn(Optional.<Endpoint>empty());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context1);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        when(this.apiRepository.save((Api) any())).thenReturn(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());

        ApiDto apiDto = new ApiDto();
        apiDto.setPort(8081);
        apiDto.setIp("127.0.0.1");
        apiDto.setStatus(false);
        apiDto.setDb(false);
        apiDto.setAnomalieList(new ArrayList<Anomalie>());
        apiDto.setPing(false);
        apiDto.setId(123L);
        apiDto.setName("Name");
        apiDto.setDiskspace(false);
        apiDto.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        apiDto.setDescription("The characteristics of someone or something");
        apiDto.setContexts(new ArrayList<Context>());
        when(this.apiConvertor.entityToDto((Api) any())).thenReturn(apiDto);

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint});
        assertNull(this.apiServiceImpl.addEndpointsToContext(123L, 123L, listEndpointDto));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveEndpointsFromContext() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult1 = Optional.<Context>of(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context1);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult1);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult2 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult2);

        ListEndpointIds listEndpointIds = new ListEndpointIds();
        listEndpointIds.setEndpoints(new Long[]{1L});
        assertSame(context1, this.apiServiceImpl.removeEndpointsFromContext(123L, 123L, listEndpointIds));
        verify(this.endpointRepository).findById((Long) any());
        verify(this.contextRepository).findById((Long) any());
        verify(this.contextRepository).save((Context) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveEndpointsFromContext2() {
        when(this.endpointRepository.findById((Long) any())).thenReturn(Optional.<Endpoint>empty());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context1);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        ListEndpointIds listEndpointIds = new ListEndpointIds();
        listEndpointIds.setEndpoints(new Long[]{1L});
        assertNull(this.apiServiceImpl.removeEndpointsFromContext(123L, 123L, listEndpointIds));
        verify(this.endpointRepository).findById((Long) any());
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveEndpointsFromContext3() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        ListEndpointIds listEndpointIds = new ListEndpointIds();
        listEndpointIds.setEndpoints(new Long[]{1L});
        assertNull(this.apiServiceImpl.removeEndpointsFromContext(123L, 123L, listEndpointIds));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testRemoveEndpointsFromContext4() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult1 = Optional.<Context>of(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context1);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult1);
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());

        ListEndpointIds listEndpointIds = new ListEndpointIds();
        listEndpointIds.setEndpoints(new Long[]{1L});
        assertNull(this.apiServiceImpl.removeEndpointsFromContext(123L, 123L, listEndpointIds));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateContextEndpoints() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);
        doThrow(new HttpClientErrorException(HttpStatus.CONTINUE)).when(this.endpointConvertor)
                .dtoToEntity((Endpoint) any(), (Endpoint) any());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult1 = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult1);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult2 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult2);

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint1});
        assertThrows(HttpClientErrorException.class,
                () -> this.apiServiceImpl.updateContextEndpoints(123L, 123L, listEndpointDto));
        verify(this.endpointRepository).findById((Long) any());
        verify(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
    }

    @Test
    void testUpdateContextEndpoints2() {
        when(this.endpointRepository.findById((Long) any())).thenReturn(Optional.<Endpoint>empty());
        doNothing().when(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint});
        assertNull(this.apiServiceImpl.updateContextEndpoints(123L, 123L, listEndpointDto));
        verify(this.endpointRepository).findById((Long) any());
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateContextEndpoints3() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult1 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult1);

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint1});
        assertNull(this.apiServiceImpl.updateContextEndpoints(123L, 123L, listEndpointDto));
        verify(this.contextRepository).findById((Long) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateContextEndpoints4() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult1 = Optional.<Context>of(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult1);
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());

        Endpoint endpoint1 = new Endpoint();
        endpoint1.setId(123L);
        endpoint1.setUrl("https://example.org/example");
        endpoint1.setName("Name");
        endpoint1.setData("Data");
        endpoint1.setMethod("Method");

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{endpoint1});
        assertNull(this.apiServiceImpl.updateContextEndpoints(123L, 123L, listEndpointDto));
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testUpdateContextEndpoints5() {
        Endpoint endpoint = new Endpoint();
        endpoint.setId(123L);
        endpoint.setUrl("https://example.org/example");
        endpoint.setName("Name");
        endpoint.setData("Data");
        endpoint.setMethod("Method");
        Optional<Endpoint> ofResult = Optional.<Endpoint>of(endpoint);
        when(this.endpointRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(this.endpointConvertor).dtoToEntity((Endpoint) any(), (Endpoint) any());

        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult1 = Optional.<Context>of(context);

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context1);
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult1);

        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        api.setAnomalies(new ArrayList<Anomalie>());
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult2 = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult2);

        ListEndpointDto listEndpointDto = new ListEndpointDto();
        listEndpointDto.setEndpoints(new Endpoint[]{});
        assertSame(context1, this.apiServiceImpl.updateContextEndpoints(123L, 123L, listEndpointDto));
        verify(this.contextRepository).findById((Long) any());
        verify(this.contextRepository).save((Context) any());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testGetTestAnomalies() {
        Api api = new Api();
        api.setPort(8081);
        api.setIp("127.0.0.1");
        api.setStatus(false);
        api.setDb(false);
        api.setPing(false);
        ArrayList<Anomalie> anomalieList = new ArrayList<Anomalie>();
        api.setAnomalies(anomalieList);
        api.setId(123L);
        api.setName("Name");
        api.setDiskspace(false);
        api.setToken("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0ZXN0In0.TFE0wutc2jaffOB3DnozLK3tnlxkuKcbVu48Pww04oj-T7XSfxrZz11-WQdPCrwgTZvydnUsZ30itbA7RCjOCMnO3qj9wAJdwpVraZiNv8X6A89m8oAHN3ngZR31LYvIoBoepiJ7D7ORe5nCp_8luEfOOjW8_hAB6Ka4kgU-mofpIDsJr9QYz9x2eBeFBCxRrmF9WdB3trs0hhE-SXoTPxZG5QeDWKE3yrxRFEvOqwUbOWLBsTLGtXpoufoSZJIzytKVdJMxMh7Wi9aZaceZuRkVrtBxgdwqmE5jD1SXMLeXqAGfjFNtQXtmgBYJuFIMA0hKRnlPXC12INOkiD8T2w");
        api.setDescription("The characteristics of someone or something");
        api.setContexts(new ArrayList<Context>());
        Optional<Api> ofResult = Optional.<Api>of(api);
        when(this.apiRepository.findById((Long) any())).thenReturn(ofResult);
        List<Anomalie> actualTestAnomalies = this.apiServiceImpl.getTestAnomalies(123L);
        assertSame(anomalieList, actualTestAnomalies);
        assertTrue(actualTestAnomalies.isEmpty());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }

    @Test
    void testGetTestAnomalies2() {
        when(this.apiRepository.findById((Long) any())).thenReturn(Optional.<Api>empty());
        assertTrue(this.apiServiceImpl.getTestAnomalies(123L).isEmpty());
        verify(this.apiRepository).findById((Long) any());
        assertTrue(this.apiServiceImpl.getAllApis().isEmpty());
    }
}

