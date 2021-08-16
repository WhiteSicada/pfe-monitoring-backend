package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcp.monitoring.dto.EquipeDto;
import com.bcp.monitoring.model.Equipe;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EquipeConvertor.class})
@ExtendWith(SpringExtension.class)
class EquipeConvertorTest {
    @Autowired
    private EquipeConvertor equipeConvertor;

    @Test
    void testEntityToDto() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        EquipeDto actualEntityToDtoResult = this.equipeConvertor.entityToDto(equipe);
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
        assertEquals("Name", actualEntityToDtoResult.getName());
    }

    @Test
    void testEntitiesToDtos() {
        assertTrue(this.equipeConvertor.entitiesToDtos(new ArrayList<Equipe>()).isEmpty());
    }

    @Test
    void testEntitiesToDtos2() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");

        ArrayList<Equipe> equipeList = new ArrayList<Equipe>();
        equipeList.add(equipe);
        List<EquipeDto> actualEntitiesToDtosResult = this.equipeConvertor.entitiesToDtos(equipeList);
        assertEquals(1, actualEntitiesToDtosResult.size());
        EquipeDto getResult = actualEntitiesToDtosResult.get(0);
        assertEquals(123L, getResult.getId().longValue());
        assertEquals("Name", getResult.getName());
    }

    @Test
    void testEntitiesToDtos3() {
        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");

        Equipe equipe1 = new Equipe();
        equipe1.setId(123L);
        equipe1.setName("Name");

        ArrayList<Equipe> equipeList = new ArrayList<Equipe>();
        equipeList.add(equipe1);
        equipeList.add(equipe);
        List<EquipeDto> actualEntitiesToDtosResult = this.equipeConvertor.entitiesToDtos(equipeList);
        assertEquals(2, actualEntitiesToDtosResult.size());
        EquipeDto getResult = actualEntitiesToDtosResult.get(1);
        assertEquals("Name", getResult.getName());
        assertEquals(123L, getResult.getId().longValue());
        EquipeDto getResult1 = actualEntitiesToDtosResult.get(0);
        assertEquals("Name", getResult1.getName());
        assertEquals(123L, getResult1.getId().longValue());
    }

    @Test
    void testDtoToEntity() {
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(123L);
        equipeDto.setName("Name");

        Equipe equipe = new Equipe();
        equipe.setId(123L);
        equipe.setName("Name");
        this.equipeConvertor.dtoToEntity(equipeDto, equipe);
        assertEquals(123L, equipe.getId().longValue());
        assertEquals("Name", equipe.getName());
    }
}

