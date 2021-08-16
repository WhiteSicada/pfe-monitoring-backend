package com.bcp.monitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bcp.monitoring.convertor.ContextConvertor;
import com.bcp.monitoring.model.Context;
import com.bcp.monitoring.model.Endpoint;
import com.bcp.monitoring.repository.ContextRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ContextServiceImpl.class, ContextConvertor.class})
@ExtendWith(SpringExtension.class)
class ContextServiceImplTest {
    @MockBean
    private ContextConvertor contextConvertor;

    @MockBean
    private ContextRepository contextRepository;

    @Autowired
    private ContextServiceImpl contextServiceImpl;

    @Test
    void testUpdateContext() {
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

        Context context2 = new Context();
        context2.setId(123L);
        context2.setName("Name");
        context2.setEndpoints(new ArrayList<Endpoint>());
        assertSame(context1, this.contextServiceImpl.updateContext(123L, context2));
        verify(this.contextRepository).findById((Long) any());
        verify(this.contextRepository).save((Context) any());
    }

    @Test
    void testUpdateContext2() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        when(this.contextRepository.save((Context) any())).thenReturn(context);
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());

        Context context1 = new Context();
        context1.setId(123L);
        context1.setName("Name");
        context1.setEndpoints(new ArrayList<Endpoint>());
        assertNull(this.contextServiceImpl.updateContext(123L, context1));
        verify(this.contextRepository).findById((Long) any());
    }

    @Test
    void testDeleteContext() {
        Context context = new Context();
        context.setId(123L);
        context.setName("Name");
        context.setEndpoints(new ArrayList<Endpoint>());
        Optional<Context> ofResult = Optional.<Context>of(context);
        doNothing().when(this.contextRepository).deleteById((Long) any());
        when(this.contextRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Context with id: 123 deleted successfully!", this.contextServiceImpl.deleteContext(123L));
        verify(this.contextRepository).deleteById((Long) any());
        verify(this.contextRepository).findById((Long) any());
    }

    @Test
    void testDeleteContext2() {
        doNothing().when(this.contextRepository).deleteById((Long) any());
        when(this.contextRepository.findById((Long) any())).thenReturn(Optional.<Context>empty());
        assertNull(this.contextServiceImpl.deleteContext(123L));
        verify(this.contextRepository).findById((Long) any());
    }
}

