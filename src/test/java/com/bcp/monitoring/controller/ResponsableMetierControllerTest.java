package com.bcp.monitoring.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.dto.ResponsableMetierDto;
import com.bcp.monitoring.service.ResponsableMetierService;
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

@ContextConfiguration(classes = {ResponsableMetierController.class})
@ExtendWith(SpringExtension.class)
class ResponsableMetierControllerTest {
    @Autowired
    private ResponsableMetierController responsableMetierController;

    @MockBean
    private ResponsableMetierService responsableMetierService;

    @Test
    void testCreateResponsableMetier() throws Exception {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        when(this.responsableMetierService.createResponsableMetier((ResponsableMetierDto) any()))
                .thenReturn(responsableMetierDto);

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(responsableMetierDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/responsablemetier")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.responsableMetierController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\"}"));
    }

    @Test
    void testUpdateResponsableMetier() throws Exception {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        when(this.responsableMetierService.updateResponsableMetier((Long) any(), (ResponsableMetierDto) any()))
                .thenReturn(responsableMetierDto);

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(responsableMetierDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/responsablemetier/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.responsableMetierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\"}"));
    }

    @Test
    void testDeleteResponsableMetier() throws Exception {
        when(this.responsableMetierService.deleteResponsableMetier((Long) any())).thenReturn("foo");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/responsablemetier/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.responsableMetierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }

    @Test
    void testDeleteResponsableMetier2() throws Exception {
        when(this.responsableMetierService.deleteResponsableMetier((Long) any())).thenReturn("foo");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/responsablemetier/{id}", 123L);
        deleteResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.responsableMetierController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }

    @Test
    void testGetAllResponsableMetiers() throws Exception {
        when(this.responsableMetierService.getAllResponsableMetiersIt()).thenReturn(new ArrayList<ResponsableMetierDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/responsablemetiers");
        MockMvcBuilders.standaloneSetup(this.responsableMetierController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllResponsableMetiers2() throws Exception {
        when(this.responsableMetierService.getAllResponsableMetiersIt()).thenReturn(new ArrayList<ResponsableMetierDto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/responsablemetiers");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.responsableMetierController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

