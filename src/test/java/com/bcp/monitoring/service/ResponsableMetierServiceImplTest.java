package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.ResponsableMetierConvertor;
import com.bcp.monitoring.dto.ResponsableMetierDto;
import com.bcp.monitoring.model.ResponsableMetier;
import com.bcp.monitoring.repository.ResponsableMetierRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResponsableMetierServiceImpl.class, ResponsableMetierConvertor.class})
@ExtendWith(SpringExtension.class)
class ResponsableMetierServiceImplTest {
    @MockBean
    private ResponsableMetierConvertor responsableMetierConvertor;

    @MockBean
    private ResponsableMetierRepository responsableMetierRepository;

    @Autowired
    private ResponsableMetierServiceImpl responsableMetierServiceImpl;

    @Test
    void testCreateResponsableMetier() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        when(this.responsableMetierRepository.save((ResponsableMetier) any())).thenReturn(responsableMetier);

        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        when(this.responsableMetierConvertor.entityToDto((ResponsableMetier) any())).thenReturn(responsableMetierDto);
        doNothing().when(this.responsableMetierConvertor)
                .dtoToEntity((ResponsableMetierDto) any(), (ResponsableMetier) any());

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertSame(responsableMetierDto, this.responsableMetierServiceImpl.createResponsableMetier(responsableMetierDto1));
        verify(this.responsableMetierRepository).save((ResponsableMetier) any());
        verify(this.responsableMetierConvertor).dtoToEntity((ResponsableMetierDto) any(), (ResponsableMetier) any());
        verify(this.responsableMetierConvertor).entityToDto((ResponsableMetier) any());
        assertTrue(this.responsableMetierServiceImpl.getAllResponsableMetiersIt().isEmpty());
    }

    @Test
    void testUpdateResponsableMetier() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        Optional<ResponsableMetier> ofResult = Optional.<ResponsableMetier>of(responsableMetier);

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");
        when(this.responsableMetierRepository.save((ResponsableMetier) any())).thenReturn(responsableMetier1);
        when(this.responsableMetierRepository.findById((Long) any())).thenReturn(ofResult);

        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        when(this.responsableMetierConvertor.entityToDto((ResponsableMetier) any())).thenReturn(responsableMetierDto);
        doNothing().when(this.responsableMetierConvertor)
                .dtoToEntity((ResponsableMetierDto) any(), (ResponsableMetier) any());

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertSame(responsableMetierDto,
                this.responsableMetierServiceImpl.updateResponsableMetier(123L, responsableMetierDto1));
        verify(this.responsableMetierRepository).findById((Long) any());
        verify(this.responsableMetierRepository).save((ResponsableMetier) any());
        verify(this.responsableMetierConvertor).dtoToEntity((ResponsableMetierDto) any(), (ResponsableMetier) any());
        verify(this.responsableMetierConvertor).entityToDto((ResponsableMetier) any());
        assertTrue(this.responsableMetierServiceImpl.getAllResponsableMetiersIt().isEmpty());
    }

    @Test
    void testUpdateResponsableMetier2() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        when(this.responsableMetierRepository.save((ResponsableMetier) any())).thenReturn(responsableMetier);
        when(this.responsableMetierRepository.findById((Long) any())).thenReturn(Optional.<ResponsableMetier>empty());

        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");
        when(this.responsableMetierConvertor.entityToDto((ResponsableMetier) any())).thenReturn(responsableMetierDto);
        doNothing().when(this.responsableMetierConvertor)
                .dtoToEntity((ResponsableMetierDto) any(), (ResponsableMetier) any());

        ResponsableMetierDto responsableMetierDto1 = new ResponsableMetierDto();
        responsableMetierDto1.setEmail("jane.doe@example.org");
        responsableMetierDto1.setId(123L);
        responsableMetierDto1.setName("Name");
        assertNull(this.responsableMetierServiceImpl.updateResponsableMetier(123L, responsableMetierDto1));
        verify(this.responsableMetierRepository).findById((Long) any());
        assertTrue(this.responsableMetierServiceImpl.getAllResponsableMetiersIt().isEmpty());
    }

    @Test
    void testGetAllResponsableMetiersIt() {
        when(this.responsableMetierRepository.findAllByOrderByIdDesc()).thenReturn(new ArrayList<ResponsableMetier>());
        ArrayList<ResponsableMetierDto> responsableMetierDtoList = new ArrayList<ResponsableMetierDto>();
        when(this.responsableMetierConvertor.entitiesToDtos((List<ResponsableMetier>) any()))
                .thenReturn(responsableMetierDtoList);
        List<ResponsableMetierDto> actualAllResponsableMetiersIt = this.responsableMetierServiceImpl
                .getAllResponsableMetiersIt();
        assertSame(responsableMetierDtoList, actualAllResponsableMetiersIt);
        assertTrue(actualAllResponsableMetiersIt.isEmpty());
        verify(this.responsableMetierRepository).findAllByOrderByIdDesc();
        verify(this.responsableMetierConvertor).entitiesToDtos((List<ResponsableMetier>) any());
    }

    @Test
    void testDeleteResponsableMetier() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        Optional<ResponsableMetier> ofResult = Optional.<ResponsableMetier>of(responsableMetier);
        doNothing().when(this.responsableMetierRepository).deleteById((Long) any());
        when(this.responsableMetierRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Responsable Metier with id: 123 deleted successfully!",
                this.responsableMetierServiceImpl.deleteResponsableMetier(123L));
        verify(this.responsableMetierRepository).deleteById((Long) any());
        verify(this.responsableMetierRepository).findById((Long) any());
        assertTrue(this.responsableMetierServiceImpl.getAllResponsableMetiersIt().isEmpty());
    }

    @Test
    void testDeleteResponsableMetier2() {
        doNothing().when(this.responsableMetierRepository).deleteById((Long) any());
        when(this.responsableMetierRepository.findById((Long) any())).thenReturn(Optional.<ResponsableMetier>empty());
        assertNull(this.responsableMetierServiceImpl.deleteResponsableMetier(123L));
        verify(this.responsableMetierRepository).findById((Long) any());
        assertTrue(this.responsableMetierServiceImpl.getAllResponsableMetiersIt().isEmpty());
    }
}

