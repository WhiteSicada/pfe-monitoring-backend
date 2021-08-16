package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.ResponsableItConvertor;
import com.bcp.monitoring.dto.ResponsableItDto;
import com.bcp.monitoring.model.ResponsableIt;
import com.bcp.monitoring.repository.ResponsableItRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResponsableItConvertor.class, ResponsableITServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ResponsableITServiceImplTest {
    @Autowired
    private ResponsableITServiceImpl responsableITServiceImpl;

    @MockBean
    private ResponsableItConvertor responsableItConvertor;

    @MockBean
    private ResponsableItRepository responsableItRepository;

    @Test
    void testCreateResponsableIt() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        when(this.responsableItRepository.save((ResponsableIt) any())).thenReturn(responsableIt);

        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        when(this.responsableItConvertor.entityToDto((ResponsableIt) any())).thenReturn(responsableItDto);
        doNothing().when(this.responsableItConvertor).dtoToEntity((ResponsableItDto) any(), (ResponsableIt) any());

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertSame(responsableItDto, this.responsableITServiceImpl.createResponsableIt(responsableItDto1));
        verify(this.responsableItRepository).save((ResponsableIt) any());
        verify(this.responsableItConvertor).dtoToEntity((ResponsableItDto) any(), (ResponsableIt) any());
        verify(this.responsableItConvertor).entityToDto((ResponsableIt) any());
        assertTrue(this.responsableITServiceImpl.getAllResponsablesIt().isEmpty());
    }

    @Test
    void testUpdateResponsableIt() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        Optional<ResponsableIt> ofResult = Optional.<ResponsableIt>of(responsableIt);

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");
        when(this.responsableItRepository.save((ResponsableIt) any())).thenReturn(responsableIt1);
        when(this.responsableItRepository.findById((Long) any())).thenReturn(ofResult);

        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        when(this.responsableItConvertor.entityToDto((ResponsableIt) any())).thenReturn(responsableItDto);
        doNothing().when(this.responsableItConvertor).dtoToEntity((ResponsableItDto) any(), (ResponsableIt) any());

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertSame(responsableItDto, this.responsableITServiceImpl.updateResponsableIt(123L, responsableItDto1));
        verify(this.responsableItRepository).findById((Long) any());
        verify(this.responsableItRepository).save((ResponsableIt) any());
        verify(this.responsableItConvertor).dtoToEntity((ResponsableItDto) any(), (ResponsableIt) any());
        verify(this.responsableItConvertor).entityToDto((ResponsableIt) any());
        assertTrue(this.responsableITServiceImpl.getAllResponsablesIt().isEmpty());
    }

    @Test
    void testUpdateResponsableIt2() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        when(this.responsableItRepository.save((ResponsableIt) any())).thenReturn(responsableIt);
        when(this.responsableItRepository.findById((Long) any())).thenReturn(Optional.<ResponsableIt>empty());

        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");
        when(this.responsableItConvertor.entityToDto((ResponsableIt) any())).thenReturn(responsableItDto);
        doNothing().when(this.responsableItConvertor).dtoToEntity((ResponsableItDto) any(), (ResponsableIt) any());

        ResponsableItDto responsableItDto1 = new ResponsableItDto();
        responsableItDto1.setEmail("jane.doe@example.org");
        responsableItDto1.setId(123L);
        responsableItDto1.setName("Name");
        assertNull(this.responsableITServiceImpl.updateResponsableIt(123L, responsableItDto1));
        verify(this.responsableItRepository).findById((Long) any());
        assertTrue(this.responsableITServiceImpl.getAllResponsablesIt().isEmpty());
    }

    @Test
    void testGetAllResponsablesIt() {
        when(this.responsableItRepository.findAllByOrderByIdDesc()).thenReturn(new ArrayList<ResponsableIt>());
        ArrayList<ResponsableItDto> responsableItDtoList = new ArrayList<ResponsableItDto>();
        when(this.responsableItConvertor.entitiesToDtos((List<ResponsableIt>) any())).thenReturn(responsableItDtoList);
        List<ResponsableItDto> actualAllResponsablesIt = this.responsableITServiceImpl.getAllResponsablesIt();
        assertSame(responsableItDtoList, actualAllResponsablesIt);
        assertTrue(actualAllResponsablesIt.isEmpty());
        verify(this.responsableItRepository).findAllByOrderByIdDesc();
        verify(this.responsableItConvertor).entitiesToDtos((List<ResponsableIt>) any());
    }

    @Test
    void testDeleteResponsibleIt() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        Optional<ResponsableIt> ofResult = Optional.<ResponsableIt>of(responsableIt);
        doNothing().when(this.responsableItRepository).deleteById((Long) any());
        when(this.responsableItRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Responsable It with id: 123 deleted successfully!",
                this.responsableITServiceImpl.deleteResponsibleIt(123L));
        verify(this.responsableItRepository).deleteById((Long) any());
        verify(this.responsableItRepository).findById((Long) any());
        assertTrue(this.responsableITServiceImpl.getAllResponsablesIt().isEmpty());
    }

    @Test
    void testDeleteResponsibleIt2() {
        doNothing().when(this.responsableItRepository).deleteById((Long) any());
        when(this.responsableItRepository.findById((Long) any())).thenReturn(Optional.<ResponsableIt>empty());
        assertNull(this.responsableITServiceImpl.deleteResponsibleIt(123L));
        verify(this.responsableItRepository).findById((Long) any());
        assertTrue(this.responsableITServiceImpl.getAllResponsablesIt().isEmpty());
    }
}

