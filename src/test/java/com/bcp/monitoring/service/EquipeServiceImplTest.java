package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.EquipeConvertor;
import com.bcp.monitoring.dto.EquipeDto;
import com.bcp.monitoring.model.Equipe;
import com.bcp.monitoring.repository.EquipeRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EquipeServiceImpl.class, EquipeConvertor.class})
@ExtendWith(SpringExtension.class)
class EquipeServiceImplTest {
    @MockBean
    private EquipeConvertor equipeConvertor;

    @MockBean
    private EquipeRepository equipeRepository;

    @Autowired
    private EquipeServiceImpl equipeServiceImpl;

    @Test
    void testCreateEquipe() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        when(this.equipeRepository.save((Equipe) any())).thenReturn(equipe);

        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");
        when(this.equipeConvertor.entityToDto((Equipe) any())).thenReturn(equipeDto);
        doNothing().when(this.equipeConvertor).dtoToEntity((EquipeDto) any(), (Equipe) any());

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertSame(equipeDto, this.equipeServiceImpl.createEquipe(equipeDto1));
        verify(this.equipeRepository).save((Equipe) any());
        verify(this.equipeConvertor).dtoToEntity((EquipeDto) any(), (Equipe) any());
        verify(this.equipeConvertor).entityToDto((Equipe) any());
        assertTrue(this.equipeServiceImpl.getEquipeList().isEmpty());
    }

    @Test
    void testUpdateEquipe() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        Optional<Equipe> ofResult = Optional.<Equipe>of(equipe);

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");
        when(this.equipeRepository.save((Equipe) any())).thenReturn(equipe1);
        when(this.equipeRepository.findById((Long) any())).thenReturn(ofResult);

        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");
        when(this.equipeConvertor.entityToDto((Equipe) any())).thenReturn(equipeDto);
        doNothing().when(this.equipeConvertor).dtoToEntity((EquipeDto) any(), (Equipe) any());

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertSame(equipeDto, this.equipeServiceImpl.updateEquipe(123L, equipeDto1));
        verify(this.equipeRepository).findById((Long) any());
        verify(this.equipeRepository).save((Equipe) any());
        verify(this.equipeConvertor).dtoToEntity((EquipeDto) any(), (Equipe) any());
        verify(this.equipeConvertor).entityToDto((Equipe) any());
        assertTrue(this.equipeServiceImpl.getEquipeList().isEmpty());
    }

    @Test
    void testUpdateEquipe2() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        when(this.equipeRepository.save((Equipe) any())).thenReturn(equipe);
        when(this.equipeRepository.findById((Long) any())).thenReturn(Optional.<Equipe>empty());

        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");
        when(this.equipeConvertor.entityToDto((Equipe) any())).thenReturn(equipeDto);
        doNothing().when(this.equipeConvertor).dtoToEntity((EquipeDto) any(), (Equipe) any());

        EquipeDto equipeDto1 = new EquipeDto();
        equipeDto1.setId(123L);
        equipeDto1.setName("Name");
        assertNull(this.equipeServiceImpl.updateEquipe(123L, equipeDto1));
        verify(this.equipeRepository).findById((Long) any());
        assertTrue(this.equipeServiceImpl.getEquipeList().isEmpty());
    }

    @Test
    void testDeleteEquipe() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        Optional<Equipe> ofResult = Optional.<Equipe>of(equipe);
        doNothing().when(this.equipeRepository).deleteById((Long) any());
        when(this.equipeRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Equipe with id: 123 deleted successfully!", this.equipeServiceImpl.deleteEquipe(123L));
        verify(this.equipeRepository).deleteById((Long) any());
        verify(this.equipeRepository).findById((Long) any());
        assertTrue(this.equipeServiceImpl.getEquipeList().isEmpty());
    }

    @Test
    void testDeleteEquipe2() {
        doNothing().when(this.equipeRepository).deleteById((Long) any());
        when(this.equipeRepository.findById((Long) any())).thenReturn(Optional.<Equipe>empty());
        assertEquals("Equipe with id: 123 Does not exists", this.equipeServiceImpl.deleteEquipe(123L));
        verify(this.equipeRepository).findById((Long) any());
        assertTrue(this.equipeServiceImpl.getEquipeList().isEmpty());
    }

    @Test
    void testGetEquipeList() {
        when(this.equipeRepository.findAllByOrderByIdDesc()).thenReturn(new ArrayList<Equipe>());
        ArrayList<EquipeDto> equipeDtoList = new ArrayList<EquipeDto>();
        when(this.equipeConvertor.entitiesToDtos((List<Equipe>) any())).thenReturn(equipeDtoList);
        List<EquipeDto> actualEquipeList = this.equipeServiceImpl.getEquipeList();
        assertSame(equipeDtoList, actualEquipeList);
        assertTrue(actualEquipeList.isEmpty());
        verify(this.equipeRepository).findAllByOrderByIdDesc();
        verify(this.equipeConvertor).entitiesToDtos((List<Equipe>) any());
    }
}

