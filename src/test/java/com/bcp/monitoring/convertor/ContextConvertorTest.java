package com.bcp.monitoring.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.model.Endpoint;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ContextConvertor.class})
@ExtendWith(SpringExtension.class)
class ContextConvertorTest {
    @Autowired
    private ContextConvertor contextConvertor;

    @Test
    void testDtoToEntity() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        this.contextConvertor.dtoToEntity(context, context1);
        assertEquals("Name", context1.getName());
        assertEquals(123L, context1.getId().longValue());
    }
}

