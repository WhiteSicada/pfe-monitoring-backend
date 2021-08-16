package com.bcp.monitoring.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.dto.ResponsableItDto;
import com.bcp.monitoring.service.ResponsableITService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ResponsableITController.class})
@ExtendWith(SpringExtension.class)
class ResponsableITControllerTest {
    @Autowired
    private ResponsableITController responsableITController;

    @MockBean
    private ResponsableITService responsableITService;

    @Test
    void testCreateResponsableIt() throws Exception {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        when(this.responsableITService.createResponsableIt((ResponsableItDto) any())).thenReturn(responsableItDto);

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(responsableItDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/responsableit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.responsableITController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\"}"));
    }

    @Test
    void testUpdateResponsableIt() throws Exception {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        when(this.responsableITService.updateResponsableIt((Long) any(), (ResponsableItDto) any()))
                .thenReturn(responsableItDto);

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(responsableItDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/responsableit/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.responsableITController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\"}"));
    }

    @Test
    void testGetAllResponsablesIt() throws Exception {
        when(this.responsableITService.getAllResponsablesIt()).thenReturn(new ArrayList<ResponsableItDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/responsableits");
        MockMvcBuilders.standaloneSetup(this.responsableITController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllResponsablesIt2() throws Exception {
        when(this.responsableITService.getAllResponsablesIt()).thenReturn(new ArrayList<ResponsableItDto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/responsableits");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.responsableITController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testDeleteResponsableIt() throws Exception {
        when(this.responsableITService.deleteResponsibleIt((Long) any())).thenReturn("foo");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/responsableit/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.responsableITController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }

    @Test
    void testDeleteResponsableIt2() throws Exception {
        when(this.responsableITService.deleteResponsibleIt((Long) any())).thenReturn("foo");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/responsableit/{id}", 123L);
        deleteResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.responsableITController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }
}

