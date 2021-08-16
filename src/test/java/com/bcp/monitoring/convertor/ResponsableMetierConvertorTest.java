package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcp.monitoring.dto.ResponsableMetierDto;
import com.bcp.monitoring.model.ResponsableMetier;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResponsableMetierConvertor.class})
@ExtendWith(SpringExtension.class)
 class ResponsableMetierConvertorTest {
    @Autowired
    private ResponsableMetierConvertor responsableMetierConvertor;

    @Test
     void testEntityToDto() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        ResponsableMetierDto actualEntityToDtoResult = this.responsableMetierConvertor.entityToDto(responsableMetier);
        assertEquals("jane.doe@example.org", actualEntityToDtoResult.getEmail());
        assertEquals("Name", actualEntityToDtoResult.getName());
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
    }

    @Test
     void testEntitiesToDtos() {
        assertTrue(this.responsableMetierConvertor.entitiesToDtos(new ArrayList<ResponsableMetier>()).isEmpty());
    }

    @Test
     void testEntitiesToDtos2() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        ArrayList<ResponsableMetier> responsableMetierList = new ArrayList<ResponsableMetier>();
        responsableMetierList.add(responsableMetier);
        List<ResponsableMetierDto> actualEntitiesToDtosResult = this.responsableMetierConvertor
                .entitiesToDtos(responsableMetierList);
        assertEquals(1, actualEntitiesToDtosResult.size());
        ResponsableMetierDto getResult = actualEntitiesToDtosResult.get(0);
        assertEquals("jane.doe@example.org", getResult.getEmail());
        assertEquals("Name", getResult.getName());
        assertEquals(123L, getResult.getId().longValue());
    }

    @Test
     void testEntitiesToDtos3() {
        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");

        ResponsableMetier responsableMetier1 = new ResponsableMetier();
        responsableMetier1.setEmail("jane.doe@example.org");
        responsableMetier1.setId(123L);
        responsableMetier1.setName("Name");

        ArrayList<ResponsableMetier> responsableMetierList = new ArrayList<ResponsableMetier>();
        responsableMetierList.add(responsableMetier1);
        responsableMetierList.add(responsableMetier);
        List<ResponsableMetierDto> actualEntitiesToDtosResult = this.responsableMetierConvertor
                .entitiesToDtos(responsableMetierList);
        assertEquals(2, actualEntitiesToDtosResult.size());
        ResponsableMetierDto getResult = actualEntitiesToDtosResult.get(1);
        assertEquals("Name", getResult.getName());
        assertEquals(123L, getResult.getId().longValue());
        assertEquals("jane.doe@example.org", getResult.getEmail());
        ResponsableMetierDto getResult1 = actualEntitiesToDtosResult.get(0);
        assertEquals("Name", getResult1.getName());
        assertEquals(123L, getResult1.getId().longValue());
        assertEquals("jane.doe@example.org", getResult1.getEmail());
    }

    @Test
     void testDtoToEntity() {
        ResponsableMetierDto responsableMetierDto = new ResponsableMetierDto();
        responsableMetierDto.setEmail("jane.doe@example.org");
        responsableMetierDto.setId(123L);
        responsableMetierDto.setName("Name");

        ResponsableMetier responsableMetier = new ResponsableMetier();
        responsableMetier.setEmail("jane.doe@example.org");
        responsableMetier.setId(123L);
        responsableMetier.setName("Name");
        this.responsableMetierConvertor.dtoToEntity(responsableMetierDto, responsableMetier);
        assertEquals("jane.doe@example.org", responsableMetier.getEmail());
        assertEquals("Name", responsableMetier.getName());
        assertEquals(123L, responsableMetier.getId().longValue());
    }
}

