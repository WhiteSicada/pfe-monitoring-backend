package com.bcp.monitoring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ScanTest {
    @Test
    void testConstructor() {
        Scan actualScan = new Scan();
        assertNull(actualScan.getApi());
        assertNull(actualScan.getUrl());
        assertNull(actualScan.getTest());
        assertNull(actualScan.getSuccessful());
        assertNull(actualScan.getStatus());
        assertNull(actualScan.getSpark());
        assertNull(actualScan.getMethod());
        assertNull(actualScan.getId());
        assertNull(actualScan.getExecutionTime());
        assertNull(actualScan.getCreatesAt());
    }

    @Test
    void testConstructor2() {
        Scan actualScan = new Scan("Api", "Test", "Status", "Spark", "Successful", "Execution Time", "Creates At", "Method",
                "https://example.org/example");

        assertEquals("Api", actualScan.getApi());
        assertEquals("https://example.org/example", actualScan.getUrl());
        assertEquals("Test", actualScan.getTest());
        assertEquals("Successful", actualScan.getSuccessful());
        assertEquals("Status", actualScan.getStatus());
        assertEquals("Spark", actualScan.getSpark());
        assertEquals("Method", actualScan.getMethod());
        assertNull(actualScan.getId());
        assertEquals("Execution Time", actualScan.getExecutionTime());
        assertEquals("Creates At", actualScan.getCreatesAt());
    }
}

