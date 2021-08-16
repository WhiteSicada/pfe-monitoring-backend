package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcp.monitoring.dto.ResponsableItDto;
import com.bcp.monitoring.model.ResponsableIt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResponsableItConvertor.class})
@ExtendWith(SpringExtension.class)
class ResponsableItConvertorTest {
    @Autowired
    private ResponsableItConvertor responsableItConvertor;

    @Test
    void testEntityToDto() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        ResponsableItDto actualEntityToDtoResult = this.responsableItConvertor.entityToDto(responsableIt);
        assertEquals("jane.doe@example.org", actualEntityToDtoResult.getEmail());
        assertEquals("Name", actualEntityToDtoResult.getName());
        assertEquals(123L, actualEntityToDtoResult.getId().longValue());
    }

    @Test
    void testEntitiesToDtos() {
        assertTrue(this.responsableItConvertor.entitiesToDtos(new ArrayList<ResponsableIt>()).isEmpty());
    }

    @Test
    void testEntitiesToDtos2() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        ArrayList<ResponsableIt> responsableItList = new ArrayList<ResponsableIt>();
        responsableItList.add(responsableIt);
        List<ResponsableItDto> actualEntitiesToDtosResult = this.responsableItConvertor.entitiesToDtos(responsableItList);
        assertEquals(1, actualEntitiesToDtosResult.size());
        ResponsableItDto getResult = actualEntitiesToDtosResult.get(0);
        assertEquals("jane.doe@example.org", getResult.getEmail());
        assertEquals("Name", getResult.getName());
        assertEquals(123L, getResult.getId().longValue());
    }

    @Test
    void testEntitiesToDtos3() {
        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");

        ResponsableIt responsableIt1 = new ResponsableIt();
        responsableIt1.setEmail("jane.doe@example.org");
        responsableIt1.setId(123L);
        responsableIt1.setName("Name");

        ArrayList<ResponsableIt> responsableItList = new ArrayList<ResponsableIt>();
        responsableItList.add(responsableIt1);
        responsableItList.add(responsableIt);
        List<ResponsableItDto> actualEntitiesToDtosResult = this.responsableItConvertor.entitiesToDtos(responsableItList);
        assertEquals(2, actualEntitiesToDtosResult.size());
        ResponsableItDto getResult = actualEntitiesToDtosResult.get(1);
        assertEquals("Name", getResult.getName());
        assertEquals(123L, getResult.getId().longValue());
        assertEquals("jane.doe@example.org", getResult.getEmail());
        ResponsableItDto getResult1 = actualEntitiesToDtosResult.get(0);
        assertEquals("Name", getResult1.getName());
        assertEquals(123L, getResult1.getId().longValue());
        assertEquals("jane.doe@example.org", getResult1.getEmail());
    }

    @Test
    void testDtoToEntity() {
        ResponsableItDto responsableItDto = new ResponsableItDto();
        responsableItDto.setEmail("jane.doe@example.org");
        responsableItDto.setId(123L);
        responsableItDto.setName("Name");

        ResponsableIt responsableIt = new ResponsableIt();
        responsableIt.setEmail("jane.doe@example.org");
        responsableIt.setId(123L);
        responsableIt.setName("Name");
        this.responsableItConvertor.dtoToEntity(responsableItDto, responsableIt);
        assertEquals("jane.doe@example.org", responsableIt.getEmail());
        assertEquals("Name", responsableIt.getName());
        assertEquals(123L, responsableIt.getId().longValue());
    }
}

