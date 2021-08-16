package com.bcp.monitoring.errorhandling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ApiErrorTest {
    @Test
    void testConstructor() {
        ApiError actualApiError = new ApiError();
        assertNull(actualApiError.getErrors());
        assertEquals("ApiError(status=null, message=null, errors=null)", actualApiError.toString());
        assertNull(actualApiError.getStatus());
        assertNull(actualApiError.getMessage());
    }

    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<String>();
        ApiError actualApiError = new ApiError(HttpStatus.CONTINUE, "Not all who wander are lost", stringList);

        List<String> errors = actualApiError.getErrors();
        assertSame(stringList, errors);
        assertTrue(errors.isEmpty());
        assertEquals("ApiError(status=100 CONTINUE, message=Not all who wander are lost, errors=[])",
                actualApiError.toString());
        assertEquals(HttpStatus.CONTINUE, actualApiError.getStatus());
        assertEquals("Not all who wander are lost", actualApiError.getMessage());
        assertSame(errors, stringList);
    }

    @Test
    void testConstructor3() {
        ApiError actualApiError = new ApiError(HttpStatus.CONTINUE, "Not all who wander are lost", "An error occurred");

        assertEquals(1, actualApiError.getErrors().size());
        assertEquals(HttpStatus.CONTINUE, actualApiError.getStatus());
        assertEquals("Not all who wander are lost", actualApiError.getMessage());
    }
}

